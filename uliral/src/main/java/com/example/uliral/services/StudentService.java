package com.example.uliral.services;

import com.example.uliral.model.entities.Student;
import com.example.uliral.model.DAO.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDaoImpl studentDao;

    @Autowired
    public StudentService(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    public void insert(Student student) {
        studentDao.insert(student);
    }

    public Student findById(String id) {
        return studentDao.findById(id);
    }

    public List<Student> findAll(String filter) {
        return studentDao.findAll(filter);
    }

    public boolean deleteById(String id) {
        return studentDao.deleteById(id);
    }

    public void update(Student student) {
        studentDao.update(student);
    }
}

