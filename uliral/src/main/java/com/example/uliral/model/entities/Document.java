package com.example.uliral.model.entities;

public class Document implements StudentEntity{
    private int id;
    private Student student;
    private String documentName;
    private String documentType;
    private String documentData;

    public Document() {
    }

    public Document(int id, Student student, String documentName, String documentType, String documentData) {
        this.id = id;
        this.student = student;
        this.documentName = documentName;
        this.documentType = documentType;
        this.documentData = documentData;
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

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentData() {
        return documentData;
    }

    public void setDocumentData(String documentData) {
        this.documentData = documentData;
    }
}
