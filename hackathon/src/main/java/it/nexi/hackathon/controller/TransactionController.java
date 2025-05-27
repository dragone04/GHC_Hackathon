package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController()
public class TransactionController {

    private final TransactionService service;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping(value = "/transaction/getAll")
    public @ResponseBody Iterable<Transaction> getAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/transaction/getAll/{customerId}")
    public @ResponseBody Iterable<Transaction> getAllById(@PathVariable Integer customerId) {
        return this.service.findAllByCustomerId(customerId);
    }

    @GetMapping(value = "/transaction/getAll/{customerId}/{startDate}/{endDate}")
    public @ResponseBody Iterable<Transaction> getAllByIdAndDate(@PathVariable Integer customerId, @PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
        return this.service.findAllByCustomerIdAndDate(customerId, startDate, endDate);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> getOne(@PathVariable String id) {
        Optional<Transaction> job = service.findOne(id);
        return job.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/transaction/{id}")
    public ResponseEntity<Transaction> updateOne(@PathVariable String id, @RequestBody Transaction updated) {
        Optional<Transaction> item = service.updateOne(id, updated);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable String id) {
        service.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

}