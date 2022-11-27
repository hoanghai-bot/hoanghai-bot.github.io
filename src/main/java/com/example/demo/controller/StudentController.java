package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.dto.StudentDto;
import com.example.demo.service.IStudentService;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController{
    private final IStudentService studentService;
    public StudentController(IStudentService studentService){this.studentService=studentService;}

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StudentDto>> getALLStudent(){
        return ResponseEntity.ok(studentService.getALLStudent());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId")Long studentId,
                              @RequestParam(required = false)String fullname,
                              @RequestParam(required = false)LocalDate dob){
        studentService.updateStudent(studentId,fullname,dob);
    }
}
