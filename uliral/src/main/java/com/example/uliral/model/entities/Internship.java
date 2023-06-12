package com.example.uliral.model.entities;

public class Internship implements StudentEntity{
    private int id;
    private Student student;
    private String companyName;
    private int duration;

    public Internship() {
    }

    public Internship(int id, Student student, String companyName, int duration) {
        this.id = id;
        this.student = student;
        this.companyName = companyName;
        this.duration = duration;
    }

    public Internship(Student student, String companyName, int duration) {
        this.student = student;
        this.companyName = companyName;
        this.duration = duration;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
