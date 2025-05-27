package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.Category;
import it.nexi.hackathon.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class CategoryController {

    private final CategoryService service;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping(value = "/category/getAll")
    public @ResponseBody Iterable<Category> getAll() {
        return this.service.findAll();

    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getOne(@PathVariable Integer id) {
        Optional<Category> item = service.findOne(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateOne(@PathVariable Integer id, @RequestBody Category updated) {
        Optional<Category> item = service.updateOne(id, updated);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Integer id) {
        service.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

}