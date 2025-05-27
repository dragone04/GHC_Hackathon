package it.nexi.hackathon.repository;

import it.nexi.hackathon.entity.Customer;
import it.nexi.hackathon.entity.Transaction;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {


}