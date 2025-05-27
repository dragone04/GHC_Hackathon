package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.Customer;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Iterable<Transaction> findAll() {
        return repository.findAll();
    }

    public Iterable<Transaction> findAllByCustomerId(Integer customerId) {
        return repository.findTransactionByCustomerCustomerId(customerId);
    }

    public Optional<Transaction> findOne(String id) {
        return repository.findById(id);
    }

    public Optional<Transaction> updateOne(String id, Transaction update) {
        return repository.findById(id).map(existing -> {
            existing.setAmount(update.getAmount());
            existing.setTransDate(update.getTransDate());
            existing.setCategory(update.getCategory());
            existing.setCustomer(update.getCustomer());
            return repository.save(existing);
        });
    }

    public void deleteOne(String id) {
        repository.deleteById(id);
    }

}
