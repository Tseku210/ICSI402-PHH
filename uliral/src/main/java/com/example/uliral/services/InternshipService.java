package com.example.uliral.services;

import com.example.uliral.model.DAO.InternshipDaoImpl;
import com.example.uliral.model.entities.Diplom;
import com.example.uliral.model.entities.Internship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {

    private final InternshipDaoImpl internshipDao;

    @Autowired
    public InternshipService(InternshipDaoImpl internshipDao) {
        this.internshipDao = internshipDao;
    }

    public boolean insert(Internship internship) {
        return internshipDao.insert(internship);
    }

    public Internship findById(int id) {
        return internshipDao.findById(id);
    }

    public List<Internship> findAll(String filter) {
        return internshipDao.findAll(filter);
    }

    public boolean deleteById(int id) {
        return internshipDao.deleteById(id);
    }

    public void update(Internship internship) {
        internshipDao.update(internship);
    }
}
