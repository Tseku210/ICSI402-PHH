package com.example.web_dev_book.ch6.complexInit;


import com.example.web_dev_book.shared.AttributeType;
import com.example.web_dev_book.shared.SetByAttribute;

public class RequestDataInit {

    protected String secretCode;
    protected int happiness;
    protected String[] extra;
    protected String comments;
    protected double grade;
    protected String[] team;

    public RequestDataInit() {
    }

    public void setSecretCode(String code) {
        this.secretCode = code;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setExtra(String[] extra) {
        this.extra = extra;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setTeam(String[] team) {
        this.team = team;
    }

    @SetByAttribute(type= AttributeType.CHECKED)
    public int getHappiness() {
        return happiness;
    }

    @SetByAttribute(type=AttributeType.SELECTED)
    public double getGrade() {
        return grade;
    }

    @SetByAttribute(type=AttributeType.CHECKED)
    public String[] getExtra() {
        return extra;
    }

    @SetByAttribute(type=AttributeType.SELECTED)
    public String[] getTeam() {
        return team;
    }

}

