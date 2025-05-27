package it.nexi.hackathon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    @Column(name = "category_id")
    private Integer transNum;



}
