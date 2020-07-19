package com.learn.amigoscode.repository;

import com.learn.amigoscode.model.Student2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository2 extends JpaRepository<Student2,Long> {

}
