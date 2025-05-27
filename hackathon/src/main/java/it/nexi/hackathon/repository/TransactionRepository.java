package it.nexi.hackathon.repository;

import it.nexi.hackathon.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;


public interface TransactionRepository extends CrudRepository<Transaction, String> {

    Iterable<Transaction> findTransactionByCustomerCustomerId(Integer customerId);

    //add a new methhod to find transactions by customerId and between and equal a date range on trans_date
    Iterable<Transaction> findTransactionByCustomerCustomerIdAndTransDateBetween(Integer customerId, LocalDate startDate, LocalDate endDate);

}