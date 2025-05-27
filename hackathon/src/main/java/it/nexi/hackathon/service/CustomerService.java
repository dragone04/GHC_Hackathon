package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.City;
import it.nexi.hackathon.entity.Customer;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.repository.CustomerRepository;
import it.nexi.hackathon.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // Add methods to interact with the transactionRepository as needed
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    public Optional<Customer> findOne(Integer id) {
        return repository.findById(id);
    }

    public Optional<Customer> updateOne(Integer id, Customer update) {
        return repository.findById(id).map(existing -> {
            existing.setCity(update.getCity());
            existing.setDob(update.getDob());
            existing.setGender(update.getGender());
            existing.setFirst(update.getFirst());
            existing.setLast(update.getLast());
            return repository.save(existing);
        });
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }
}
