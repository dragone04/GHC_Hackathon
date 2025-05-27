package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.City;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.service.CategoryService;
import it.nexi.hackathon.service.CityService;
import it.nexi.hackathon.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CityController {

    private final CityService service;

    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping(value = "/getAllCities")
    public @ResponseBody Iterable<City> getAllCities() {
        return this.service.findAll();

    }

}