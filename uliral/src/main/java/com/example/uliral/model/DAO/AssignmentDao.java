package com.example.uliral.model.DAO;

import com.example.uliral.model.entities.Assignment;
import com.example.uliral.model.entities.Internship;

import java.util.List;

public interface AssignmentDao {
    boolean insert(Assignment assignment);
    Assignment findById(int id);
    List<Assignment> findAll(String filter);
    boolean deleteById(int id);
    void update(Assignment assignment);
}
