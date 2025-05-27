package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.City;
import it.nexi.hackathon.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public Iterable<City> findAll() {
        return repository.findAll();
    }

    public Optional<City> findOne(Integer id) {
        return repository.findById(id);
    }

    public Optional<City> updateOne(Integer id, City update) {
        return repository.findById(id).map(existing -> {
            existing.setCityName(update.getCityName());
            return repository.save(update);
        });
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

}
