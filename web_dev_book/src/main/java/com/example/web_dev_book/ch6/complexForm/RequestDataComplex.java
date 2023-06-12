package com.example.web_dev_book.ch6.complexForm;

public class RequestDataComplex {

    protected String secretCode;
    protected int happiness;
    protected String[] extra;
    protected String comments;
    protected double grade;
    protected String[] team;

    public RequestDataComplex() {
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

    public int getHappiness() {
        return happiness;
    }

    public void setExtra(String[] extra) {
        this.extra = extra;
    }

    public String[] getExtra() {
        return extra;
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

    public double getGrade() {
        return grade;
    }

    public void setTeam(String[] team) {
        this.team = team;
    }

    public String[] getTeam() {
        return team;
    }
}
