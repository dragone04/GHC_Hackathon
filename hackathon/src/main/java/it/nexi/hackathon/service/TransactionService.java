package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Add methods to interact with the transactionRepository as needed
    public Iterable<Transaction> findAllAsList() {

        return transactionRepository.findAll();
    }
}
