package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getStudentByCity(String city);
    List<Student> getAllStudents();
    void studentAdd( Student student);

}
