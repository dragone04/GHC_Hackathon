package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.Customer;
import it.nexi.hackathon.entity.Job;
import it.nexi.hackathon.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JobService {

    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    public Iterable<Job> findAll() {
        return repository.findAll();
    }

    public Optional<Job> findOne(Integer id) {
        return repository.findById(id);
    }

    public Optional<Job> updateOne(Integer id, Job update) {
        return repository.findById(id).map(existing -> {
            existing.setJobName(update.getJobName());
            return repository.save(existing);
        });
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

}
