package com.example.uliral.model.DAO;

import com.example.uliral.model.entities.Diplom;
import com.example.uliral.model.entities.Internship;

import java.util.List;

public interface InternshipDao {
    boolean insert(Internship intern);
    Internship findById(int id);
    List<Internship> findAll(String filter);
    boolean deleteById(int id);
    void update(Internship intern);
}
