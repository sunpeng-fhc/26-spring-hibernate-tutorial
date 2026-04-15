package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Ethan","Walker"));
        theStudents.add(new Student("Sophia","Bennett"));
        theStudents.add(new Student("Lucas","Carter"));
        theStudents.add(new Student("Olivia","Hughes"));
    }


    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    // define endpoint or  "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")

    public Student getStudentById(@PathVariable int studentId){

        if ((studentId >= theStudents.size()) || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }


        return theStudents.get(studentId);
    }










}
