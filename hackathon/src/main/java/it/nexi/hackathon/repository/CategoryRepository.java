package it.nexi.hackathon.repository;

import it.nexi.hackathon.entity.Category;
import it.nexi.hackathon.entity.Transaction;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Integer> {


}