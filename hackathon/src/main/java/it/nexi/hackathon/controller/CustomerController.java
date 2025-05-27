package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.Customer;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.service.CityService;
import it.nexi.hackathon.service.CustomerService;
import it.nexi.hackathon.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    private final CustomerService service;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(value = "/getAllCustomers")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return this.service.findAll();

    }

}