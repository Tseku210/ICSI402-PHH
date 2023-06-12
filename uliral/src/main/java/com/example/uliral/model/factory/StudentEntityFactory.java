package com.example.uliral.model.factory;

import com.example.uliral.model.entities.*;
import com.example.uliral.model.enums.StudentEntityType;

public class StudentEntityFactory {
    public static StudentEntity createEntity(StudentEntityType type) {
        switch (type) {
            case STUDENT:
                return new Student();
            case DIPLOMA:
                return new Diplom();
            case INTERNSHIP:
                return new Internship();
            case ASSIGNMENT:
                return new Assignment();
            case DOCUMENT:
                return new Document();
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
