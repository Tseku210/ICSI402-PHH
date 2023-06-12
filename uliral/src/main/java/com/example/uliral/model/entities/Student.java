package com.example.uliral.model.entities;

import java.io.Serializable;

public class Student implements Serializable, StudentEntity {
    private String student_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;

    public Student() {

    }

    public Student(String student_id) {
        this.student_id = student_id;
    }

    public Student(String student_id, String firstName, String lastName, String email, String phoneNo) {
        this.student_id = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
