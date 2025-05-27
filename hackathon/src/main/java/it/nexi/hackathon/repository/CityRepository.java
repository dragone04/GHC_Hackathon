package it.nexi.hackathon.repository;

import it.nexi.hackathon.entity.City;
import it.nexi.hackathon.entity.Transaction;
import org.springframework.data.repository.CrudRepository;


public interface CityRepository extends CrudRepository<City, Integer> {


}