package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.Customer;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.repository.CustomerRepository;
import it.nexi.hackathon.repository.TransactionRepository;
import org.springframework.stereotype.Service;


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
}
