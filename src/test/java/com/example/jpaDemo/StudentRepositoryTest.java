package com.example.jpaDemo;

import com.example.jpaDemo.model.Student;
import com.example.jpaDemo.repository.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepo studentRepo;

    @Test
    public void findByPercentageGreaterThanTest()
    {
        Student student1=new Student(1,"RamSita","Ayodhya",100);
        Student student2=new Student(2,"Raj","Warshaw",98);
        Student student3=new Student(3,"Khushi","Paris",99);
        Student student4=new Student(4,"Fred","Washington",78);
        studentRepo.save(student1);
        studentRepo.save(student2);
        studentRepo.save(student3);
        studentRepo.save(student4);
        List<Student> students=this.studentRepo.findByPercentageGreaterThan(97);
        System.out.println(students.size());
    }
    @Test
public void findByCityTest()
{
    Student student1=new Student(1,"RamSita","Ayodhya",100);
    Student student2=new Student(2,"Raj","Warshaw",98);
    Student student3=new Student(3,"Khushi","Warshaw",99);
    Student student4=new Student(4,"Fred","Washington",78);
    studentRepo.save(student1);
    studentRepo.save(student2);
    studentRepo.save(student3);
    studentRepo.save(student4);
    List<Student> students=this.studentRepo.findByCity("Warshaw");
    System.out.println(students.size());
}
}
