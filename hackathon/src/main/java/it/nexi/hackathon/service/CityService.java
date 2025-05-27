package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.City;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.repository.CityRepository;
import it.nexi.hackathon.repository.TransactionRepository;
import org.springframework.stereotype.Service;


@Service
public class CityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    // Add methods to interact with the transactionRepository as needed
    public Iterable<City> findAll() {
        return repository.findAll();
    }
}
