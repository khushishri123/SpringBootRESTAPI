package com.example.jpaDemo.service;

import com.example.jpaDemo.model.Student;
import com.example.jpaDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    public String addStudent(Student student)
    {
        if(this.studentRepo.existsById(student.getRollNumber()))
        {
            return "Student already exists";
        }
        else
        {
            this.studentRepo.save(student);
            return "Student added successfully";
        }
    }
    public List<Student> getStudents() {
        return this.studentRepo.findAll();
    }
    public Student getStudentByRollNumber(Integer rollNumber)
    {
        return this.studentRepo.findById(rollNumber).get();
    }
    public String updateStudent(Student student){
        if(studentRepo.existsById(student.getRollNumber())==false)
        {
            return "Student does not exists";
        }
        Student s1=studentRepo.getReferenceById(student.getRollNumber());
        s1.setName(student.getName());
        s1.setCity(student.getCity());
        s1.setPercentage(student.getPercentage());
        this.studentRepo.save(s1);
        return "Student updated successfully";
    }
    public String deleteStudentById(Integer rollNumber)
    {
        if(this.studentRepo.existsById(rollNumber))
        {
            this.studentRepo.deleteById(rollNumber);
            return "Student deleted successfully";
        }
        return "Student Not Found";
    }
}
