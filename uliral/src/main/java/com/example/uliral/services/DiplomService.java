package com.example.uliral.services;

import com.example.uliral.model.DAO.DiplomDaoImpl;
import com.example.uliral.model.entities.Diplom;
import com.example.uliral.model.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomService {

    private final DiplomDaoImpl diplomDao;

    @Autowired
    public DiplomService(DiplomDaoImpl diplomDao) {
        this.diplomDao = diplomDao;
    }


    public boolean insert(Diplom diplom) {
       return diplomDao.insert(diplom);
    }

    public Diplom findById(int id) {
        return diplomDao.findById(id);
    }

    public List<Diplom> findAll(String filter) {
        return diplomDao.findAll(filter);
    }

    public boolean deleteById(int id) {
        return diplomDao.deleteById(id);
    }

    public void update(Diplom diplom) {
        diplomDao.update(diplom);
    }
}