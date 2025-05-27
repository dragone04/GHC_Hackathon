package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.Category;
import it.nexi.hackathon.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    public Optional<Category> findOne(Integer id) {
        return repository.findById(id);
    }

    public Optional<Category> updateOne(Integer id, Category update) {
        return repository.findById(id).map(existing -> {
            existing.setCategoryName(update.getCategoryName());
            return repository.save(existing);
        });
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

}
