package com.example.uliral.model.entities;

public class Assignment implements StudentEntity{
    int id;
    private Student student;
    private String assignmentName;
    private String dueDate;
    private String courseName;

    public Assignment() {
    }

    public Assignment(int id, Student student, String assignmentName, String dueDate, String courseName) {
        this.id = id;
        this.student = student;
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
        this.courseName = courseName;
    }

    public Assignment(Student student, String assignmentName, String dueDate, String courseName) {
        this.student = student;
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
        this.courseName = courseName;
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

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
