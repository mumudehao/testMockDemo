package com.mockitotest.testMockDemo.dao;

import com.mockitotest.testMockDemo.domain.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

    public Student getStudentById(int id) {
        return new Student(1, 18, "tony");

    }
}
