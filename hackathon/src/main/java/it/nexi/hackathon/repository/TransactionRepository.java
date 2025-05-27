package it.nexi.hackathon.repository;

import it.nexi.hackathon.entity.Transaction;
import org.springframework.data.repository.CrudRepository;


public interface TransactionRepository extends CrudRepository<Transaction, Integer> {


}