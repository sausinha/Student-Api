package com.example.TestProj.controllers;

import com.example.TestProj.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @GetMapping(value = "student-list", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> allStudents() {

        List<Student> studentList;
        studentList = IntStream.rangeClosed(1, 100000).boxed().map(i -> {
            Student student = new Student();
            student.setId(i);
            student.setEmail("ss" + i + "@gmail.com");
            student.setName("TestStudent" + i);
            student.setDegree("TestDegree" + i);
            student.setAge(22);
            student.setAddress("TestAddress"+i);
            student.setTotalMarks(85);
            return student;
        }).collect(Collectors.toList());

        return studentList;

    }

    @GetMapping(value = "status-check")
    public String statusCheck() {
        return "Service is UP";
    }
}
