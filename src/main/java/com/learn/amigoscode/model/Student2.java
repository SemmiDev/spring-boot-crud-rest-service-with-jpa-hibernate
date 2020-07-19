package com.learn.amigoscode.model;

import lombok.Data;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
public class Student2 {
    // with h2 database (memory db)
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String nisn;
}
