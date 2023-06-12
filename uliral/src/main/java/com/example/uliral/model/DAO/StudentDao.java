package com.example.uliral.model.DAO;

import com.example.uliral.model.entities.Student;

import java.util.List;

public interface StudentDao {
    void insert(Student student);
    Student findById(String id);
    List<Student> findAll(String filter);
    boolean deleteById(String id);
    void update(Student student);
}
