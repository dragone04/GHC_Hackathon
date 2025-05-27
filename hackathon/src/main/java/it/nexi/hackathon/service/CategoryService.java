package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.Category;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.repository.CategoryRepository;
import it.nexi.hackathon.repository.TransactionRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    // Add methods to interact with the transactionRepository as needed
    public Iterable<Category> findAll() {
        return repository.findAll();
    }
}
