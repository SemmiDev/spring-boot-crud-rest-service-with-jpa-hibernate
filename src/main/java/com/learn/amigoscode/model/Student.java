package com.learn.amigoscode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nisn")
    private String nisn;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "Jurusan")
    private String jurusan;

    @Column(name = "age")
    private Integer age;

    @Column(name = "Address")
    private String address;

    public Student(
            String firstName,
            String lastName,
            Integer age,
            String jurusan,
            String address,
            String nisn)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.jurusan = jurusan;
        this.address = address;
        this.nisn = nisn;
    }
}
