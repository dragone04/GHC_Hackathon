package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.Customer;
import it.nexi.hackathon.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController()
public class CustomerController {

    private final CustomerService service;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(value = "/customer/getAll")
    public @ResponseBody Iterable<Customer> getAll() {
        return this.service.findAll();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getOne(@PathVariable Integer id) {
        Optional<Customer> item = service.findOne(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateOne(@PathVariable Integer id, @RequestBody Customer updated) {
        Optional<Customer> item = service.updateOne(id, updated);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Integer id) {
        service.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

}