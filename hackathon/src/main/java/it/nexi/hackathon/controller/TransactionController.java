package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionController {

    private final TransactionService transactionService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/getAllTransactions")
    public @ResponseBody Iterable<Transaction> getAllTransactions() {

        return this.transactionService.findAll();

    }
}