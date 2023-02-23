package com.example.jpaDemo.repository;

import com.example.jpaDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface StudentRepo extends JpaRepository <Student,Integer>{
    List<Student> findByPercentageGreaterThan(float percentage);
    List<Student> findByCity(String city);

}
