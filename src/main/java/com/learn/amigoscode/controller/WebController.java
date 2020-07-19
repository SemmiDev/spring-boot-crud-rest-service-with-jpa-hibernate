package com.learn.amigoscode.controller;

import com.learn.amigoscode.model.Student;
import com.learn.amigoscode.repository.StudentRepository;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassDynamicTypeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.remote.SubjectDelegationPermission;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class WebController {
    UUID uuid = UUID.randomUUID();

    @Autowired
    private StudentRepository repository;

    @GetMapping("/")
    public String index() {
        return "Spring JPA PostgreSQL Example.<br>TODAY ->  " + new Date();
    }

    @GetMapping("/save")
    public String process() {
        repository.save(new Student("Sammi", "Aldhiyanto", 19, "MIPA","Tinggam",uuid.toString()));
        repository.save(new Student("Adisti", "Listianova", 86, "MIPA", "Talu",uuid.toString()));
        repository.save(new Student("Aditya", "Andika Putra", 19, "MIPA", "Talu",uuid.toString()));
        repository.save(new Student("Ayatullah", "Ramadhan", 19, "MIPA", "Talu",uuid.toString()));
        repository.save(new Student("Dandi", "Arnanda", 19, "MIPA", "Talu",uuid.toString()));
        repository.save(new Student("Naara", "Shikamaru", 19, "MIPA", "Konoha",uuid.toString()));
        repository.save(new Student("Aburame", "Shino", 19, "MIPA", "Konoha",uuid.toString()));
        repository.save(new Student("Hyuuga", "Neji", 19, "MIPA", "Konoha",uuid.toString()));
        repository.save(new Student("Hyuuga", "Hinata", 19, "MIPA", "Konoha",uuid.toString()));
        repository.save(new Student("Yamanaka", "Ino", 19, "MIPA", "Konoha",uuid.toString()));
        repository.save(new Student("Akimichi", "Choji", 19, "MIPA", "Konoha",uuid.toString()));
        repository.save(new Student("Inuzuka", "Kiba", 19, "MIPA", "Konoha",uuid.toString()));
        repository.save(new Student("Rock", "Lee", 19, "MIPA", "Sunagakure",uuid.toString()));
        repository.save(new Student("Sarutobi", "Hiruzen", 19, "MIPA", "Kumogakure",uuid.toString()));
        return "Done";
    }

    @GetMapping("/find/all")
    public Iterable<Student> findAll() {
        return repository.findAll();
    }

    @GetMapping("/find/id")
    public Student findById(@RequestParam("id") long id) {
        Optional<Student> resultOpt = repository.findById(id);
        Student student = resultOpt.get();
        return student;
    }


    @GetMapping("/find/nisn")
    public List<Student> fetchByNisn(@RequestParam("nisn") String nisn) {
        return repository.findByNisn(nisn);
    }

    @GetMapping("/find/firstname")
    public List<Student> fetchDataByFirstName(@RequestParam("firstname") String firstname) {
        return repository.findByFirstName(firstname);
    }

    @GetMapping("/find/lastname")
    public List<Student> fetchDataByLastName(@RequestParam("lastname") String lastName) {
        return repository.findByLastName(lastName);
    }

    @GetMapping("/find/age")
    public List<Student> fetchByAge(@RequestParam("age") Integer age) {
        return repository.findByAge(age);
    }

    @GetMapping("/find/address")
    public List<Student> fetchByAddress(@RequestParam("address") String address){
        return repository.findByAddress(address);
    }

    @GetMapping("/find/jurusan")
    public List<Student> fetchByJurusan(@RequestParam("jurusan") String jurusan) {
        return repository.findByJurusan(jurusan);
    }
}
