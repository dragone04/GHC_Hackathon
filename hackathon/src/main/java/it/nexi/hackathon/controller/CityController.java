package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.City;
import it.nexi.hackathon.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CityController {

    private final CityService service;

    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping(value = "/city/getAll")
    public @ResponseBody Iterable<City> getAll() {
        return this.service.findAll();

    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getOne(@PathVariable Integer id) {
        Optional<City> item = service.findOne(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/city/{id}")
    public ResponseEntity<City> updateOne(@PathVariable Integer id, @RequestBody City updated) {
        Optional<City> item = service.updateOne(id, updated);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Integer id) {
        service.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

}