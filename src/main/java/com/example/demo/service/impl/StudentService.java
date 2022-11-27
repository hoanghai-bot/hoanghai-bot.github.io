package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.entity.dto.StudentDto;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;
    public StudentService(IStudentRepository studentRepository){this.studentRepository = studentRepository;}

    @Override
    public List<StudentDto> getALLStudent(){
        List<Student> studentList =studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student s: studentList)  {
            studentDtoList.add(new StudentDto(s.getId(),s.getFullname(),s.getAge() ));
        }
        return studentDtoList;
    }


    public void addNewStudent(Student student) {
        Optional<Student> StudentOptional = studentRepository.findStudentByPersonalIdentity(student.getPersonalIdentity());
        if (StudentOptional.isPresent()) {
            throw new IllegalStateException("chung minh thu da co");
        }
        studentRepository.save(student);
        
    }



    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("hoc sinh voi ma id "+studentId+" ko ton tai"));
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String fullname, LocalDate dob) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("hoc sinh voi ma id "+ studentId +" ko ton tai"));
        if (fullname != null && fullname.length()>0 &&
        !Objects.equals(student.getFullname(),fullname)){
            student.setFullname(fullname);
        }
        if (dob != null && !Objects.equals(student.getDob(),dob)){
            student.setDob(dob);
        }
    }

}
