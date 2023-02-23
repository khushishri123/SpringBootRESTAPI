package com.example.jpaDemo;

import com.example.jpaDemo.model.Student;
import com.example.jpaDemo.repository.StudentRepo;
import com.example.jpaDemo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepo studentRepo;

    Student student ;
    @BeforeEach
    void setUp()
    {
     this.student=new Student(1,"Raj","Warshaw",98);
    }
    @Test
    public void createStudentTest()
    {
        Student student1=new Student(1,"Sid","Ujjain",97);
when(this.studentRepo.existsById(1)==true).thenReturn(false);
String s=this.studentService.addStudent(student1);
System.out.println(s);
assertEquals("Student added successfully",s);
    }

    @Test
    public void getStudentsTest()
    {
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Raj","Warshaw",98));
        studentList.add(new Student(2,"Khushi","Warshaw",99));
        studentList.add(new Student(3,"Stuti","Paris",97));
        when(this.studentRepo.findAll()).thenReturn(studentList);
        List<Student> students=this.studentService.getStudents();
        assertNotNull(students);
        System.out.println(students.size());
        assertEquals(3,students.size());
    }

    @Test
    public void getStudentByRollNumberTest()
    {
        when(this.studentRepo.findById(1)).thenReturn(Optional.of(student));
        Student student2=this.studentService.getStudentByRollNumber(1);
        System.out.println(student2);
        assertEquals(student2.getName(),"Raj");
    }

    @Test
    public void updateStudentTest()
    {
Student student1=new Student(1,"Sid","Warshaw",98);
when(this.studentRepo.existsById(1)).thenReturn(true);
when(this.studentRepo.getReferenceById(1)).thenReturn(student1);
String updated=this.studentService.updateStudent(new Student(1,"Raj","Warshaw",99));
System.out.println(updated);
assertEquals("Student updated successfully",updated);
    }

    @Test
    public void deleteStudentByIdTestCase()
    {
        when(this.studentRepo.existsById(1)).thenReturn(true);
        String result=this.studentService.deleteStudentById(1);
        System.out.println(result);
        assertEquals("Student deleted successfully",result);
    }

}
