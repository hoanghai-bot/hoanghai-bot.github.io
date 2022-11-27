package com.example.demo.service;


import com.example.demo.entity.Student;
import com.example.demo.entity.dto.StudentDto;

import java.time.LocalDate;
import java.util.List;

public interface IStudentService {
    List<StudentDto> getALLStudent();


    void addNewStudent(Student student);

    void deleteStudent(Long studentId);

    void updateStudent(Long studentId, String fullname, LocalDate dob);
}
