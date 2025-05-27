package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.Category;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.service.CategoryService;
import it.nexi.hackathon.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryController {

    private final CategoryService service;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping(value = "/getAllCategories")
    public @ResponseBody Iterable<Category> getAllCategories() {
        return this.service.findAll();

    }
}