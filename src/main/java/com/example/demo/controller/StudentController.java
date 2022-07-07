package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/student-details")
    public ResponseEntity<List<Student>> studentDetails(@RequestParam String city){

        List<Student> studentList = studentService.getStudentByCity(city);

        if(studentList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(studentList,HttpStatus.OK);

    }

    @RequestMapping(value = "/student-list",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> studentList(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }


    @PostMapping(value = "/add-student" ,consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> createStudent(@Valid @RequestBody Student student) {

                 studentService.studentAdd(student);

        return ResponseEntity.ok("Student is valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
