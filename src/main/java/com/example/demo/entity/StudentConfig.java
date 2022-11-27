package com.example.demo.entity;

import com.example.demo.repository.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(IStudentRepository iStudentRepository){
    return args -> {
        Student hai = new Student(
                1L,
                "Hai",
                LocalDate.of(2002, Month.DECEMBER, 22),
                21321222L
        );
        Student anyone = new Student(
                2L,
                "anyone",
                LocalDate.of(2000,Month.AUGUST,4),
                123246432L
        );
        iStudentRepository.saveAll(
                List.of(hai,anyone)
        );
    };
    };

}
