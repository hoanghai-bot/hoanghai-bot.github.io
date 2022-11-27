package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullname;

    private LocalDate dob;
    private Long personalIdentity;
    @Transient
    private Integer age;

    public Student(Long id, String fullname, LocalDate dob, Long personalIdentity) {
        this.id = id;
        this.fullname = fullname;
        this.dob = dob;
        this.personalIdentity = personalIdentity;
    }

    public Student(String fullname, LocalDate dob, Long personalIdentity) {
        this.fullname = fullname;
        this.dob = dob;
        this.personalIdentity = personalIdentity;
    }

    public Student() {
    }

    public Integer getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }



    public Long getPersonalIdentity() {
        return personalIdentity;
    }

    public void setPersonalIdentity(Long personalIdentity) {
        this.personalIdentity = personalIdentity;
    }
}

