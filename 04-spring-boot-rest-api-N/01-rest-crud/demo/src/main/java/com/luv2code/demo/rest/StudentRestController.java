package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private ArrayList<Student> theStudents;

    //define @PostConstruct to load the student data...only once!
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();
        theStudents.add(new Student("Nisha","Kadam"));
        theStudents.add(new Student("supu","ka"));
        theStudents.add(new Student("karan","sajwani"));
    }
    //define endpoint for "/students return a list of students

    @GetMapping("/students")
    public ArrayList<Student> getStudents()
    {

        return  theStudents;
    }

    //define endpoints or "/students/{studentId}" return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        //just index into the list..keep it simple

        //check the studnetsId against the list size
        if((studentId>=theStudents.size()) || (studentId < 0 ))
        {
            throw new StudentNotFoundException("Students id not found -"+studentId);
        }
        return theStudents.get(studentId);
    }

    //Add an exception handler using @Exemptionhandler

}



















