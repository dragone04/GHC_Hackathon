package it.nexi.hackathon.controller;

import it.nexi.hackathon.entity.Job;
import it.nexi.hackathon.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController()
public class JobController {

    private final JobService service;

    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping(value = "/job/getAll")
    public ResponseEntity<Iterable<Job>> getAll() {
        return ResponseEntity.ok(this.service.findAll());

    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getOne(@PathVariable Integer id) {
        Optional<Job> job = service.findOne(id);
        return job.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateOne(@PathVariable Integer id, @RequestBody Job updatedJob) {
        Optional<Job> job = service.updateOne(id, updatedJob);
        return job.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Integer id) {
        service.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

}