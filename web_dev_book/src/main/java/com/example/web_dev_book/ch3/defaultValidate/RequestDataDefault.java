package com.example.web_dev_book.ch3.defaultValidate;

public class RequestDataDefault {
    protected String hobby;
    protected String aversion;

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        if (isValidHobby()) {
            return hobby;
        }
        return "No Hobby";
    }

    public void setAversion(String aversion) {
        this.aversion = aversion;
    }

    public String getAversion() {
        if (isValidAversion()) {
            return aversion;
        }
        return "No Aversion";
    }

    public boolean isValidHobby() {
        return hobby != null && !hobby.trim().equals("");
    }

    public boolean isValidAversion() {
        return aversion != null && !aversion.trim().equals("");
    }
}
