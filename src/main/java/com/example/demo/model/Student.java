package com.example.demo.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.NumberFormat;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Student number should be fill")
    private String studentNumber;

    @NotBlank(message = "Student name should be fill")
    private String studentName;


    @NotBlank(message = "Student city should be fill")
    private String city;

    @NotBlank(message = "Student city should be fill")
    @Email
    private String email;


    @NotBlank
    @Size(max = 10, min = 10)
    @NumberFormat
    private String phoneNo;


    public Student() {
    }

    public Student(String studentNumber, String studentName, String city,String email , String phoneNo) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.city = city;
        this.email = email ;
        this.phoneNo = phoneNo ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
