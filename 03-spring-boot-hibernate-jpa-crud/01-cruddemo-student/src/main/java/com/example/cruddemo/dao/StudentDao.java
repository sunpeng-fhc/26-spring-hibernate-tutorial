package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {


    void save (Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();
}
