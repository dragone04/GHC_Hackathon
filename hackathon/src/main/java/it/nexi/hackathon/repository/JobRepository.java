package it.nexi.hackathon.repository;

import it.nexi.hackathon.entity.City;
import it.nexi.hackathon.entity.Job;
import org.springframework.data.repository.CrudRepository;


public interface JobRepository extends CrudRepository<Job, Integer> {


}