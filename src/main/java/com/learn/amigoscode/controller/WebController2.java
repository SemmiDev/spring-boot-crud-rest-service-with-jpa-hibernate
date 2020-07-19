package com.learn.amigoscode.controller;

import com.learn.amigoscode.model.Student;
import com.learn.amigoscode.model.Student2;
import com.learn.amigoscode.repository.StudentRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class WebController2 {

    @Autowired
    private StudentRepository2 repository2;

    @GetMapping("students2")
    public List<Student2> retrieveAllStudent2(){
        return repository2.findAll();
    }

    @GetMapping("/find2/{id}")
    public Student2 retreiveStudent(@PathVariable long id) throws Exception {
        Optional<Student2> student2 = repository2.findById(id);
        if (!student2.isPresent())
            throw new Exception("tidak ditemukan student dengan id : " + id);
        return student2.get();
    }

    @DeleteMapping("/delete2/{id}")
    public void deleteStudent(@PathVariable long id) {
        repository2.deleteById(id);
    }

    @PostMapping("/students2")
    public ResponseEntity<Object> createStudent(@RequestBody Student2 student2) {
        Student2 savedStudent = repository2.save(student2);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student2 student, @PathVariable long id) {

        Optional<Student2> studentOptional = repository2.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        // test
        // https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
        student.setId(id);
        repository2.save(student);
        return ResponseEntity.noContent().build();
    }
}
