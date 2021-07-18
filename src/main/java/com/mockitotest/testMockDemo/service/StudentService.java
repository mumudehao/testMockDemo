package com.mockitotest.testMockDemo.service;


import com.mockitotest.testMockDemo.dao.StudentDao;
import com.mockitotest.testMockDemo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }
}
