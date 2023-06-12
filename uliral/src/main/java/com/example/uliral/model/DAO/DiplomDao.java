package com.example.uliral.model.DAO;

import com.example.uliral.model.entities.Diplom;
import com.example.uliral.model.entities.Student;

import java.util.List;

public interface DiplomDao {
    boolean insert(Diplom diplom);
    Diplom findById(int id);
    List<Diplom> findAll(String filter);
    boolean deleteById(int id);
    void update(Diplom diplom);
}
