package com.example.jpaDemo.controller;

import com.example.jpaDemo.model.Student;
import com.example.jpaDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentControlller {
   @Autowired
    private StudentService studentService;
    @GetMapping("/home")
    public String studentHome()
    {
        return "student.html";
    }
    //get list of students
    @GetMapping("/studentsList")
    public List<Student> getStudents()
    {
        return this.studentService.getStudents();
    }

    @GetMapping("/getStudentByRollNumber")
    public Student getStudentByRollNumber(@RequestParam Integer rollNumber)
    {
        return this.studentService.getStudentByRollNumber(rollNumber);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student)
    {
       return this.studentService.addStudent(student);
    }
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student)
    {
   return this.studentService.updateStudent(student);
    }
    @DeleteMapping("/deleteStudentById")
    public String deleteStudentById(@RequestParam("rollNumber") Integer rollNumber)
    {
return this.studentService.deleteStudentById(rollNumber);
    }
}
