package com.example.demo.entity.dto;

public class StudentDto {
    private Long id;
    private String fullname;
    private Integer age;

    public StudentDto() {
    }

    public StudentDto(Long id, String fullname, Integer age) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
