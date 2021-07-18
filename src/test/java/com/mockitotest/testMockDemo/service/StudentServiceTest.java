package com.mockitotest.testMockDemo.service;

import com.mockitotest.testMockDemo.dao.StudentDao;
import com.mockitotest.testMockDemo.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.util.Assert;


@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @MockBean
    StudentDao studentDao;

    @BeforeEach
    void setUp() {
        Mockito.when(studentDao.getStudentById(1)).thenReturn(new Student(1,18,"tony"));
    }

    @Test
    void getStudentById() {
        Student student = studentService.getStudentById(1);
        Assert.notNull(student);
//        Assert.isTrue(student.getAge(),18);

    }
}