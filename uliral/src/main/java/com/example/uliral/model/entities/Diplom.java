package com.example.uliral.model.entities;

public class Diplom implements StudentEntity{
    private int id;
    private Student student;
    private String degreeName;
    private String universityName;
    private String graduationYear;

    public Diplom() {

    }

    public Diplom(int id, Student student, String degreeName, String universityName, String graduationYear) {
        this.id = id;
        this.student = student;
        this.degreeName = degreeName;
        this.universityName = universityName;
        this.graduationYear = graduationYear;
    }

    public Diplom(Student student, String degreeName, String universityName, String graduationYear) {
        this.student = student;
        this.degreeName = degreeName;
        this.universityName = universityName;
        this.graduationYear = graduationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }
}
