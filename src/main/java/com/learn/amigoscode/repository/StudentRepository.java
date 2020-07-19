package com.learn.amigoscode.repository;

import com.learn.amigoscode.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface StudentRepository extends CrudRepository<Student, Long>{

    List<Student> findByNisn(String nisn);
    List<Student> findByLastName(String lastName);
    List<Student> findByFirstName(String firstname);
    List<Student> findByAddress(String address);
    List<Student> findByJurusan(String jurusan);
    List<Student> findByAge(Integer age);
}

