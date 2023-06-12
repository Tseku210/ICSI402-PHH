package com.example.web_dev_book.ch5.persistentData;

import com.example.web_dev_book.shared.PersistentBase;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class RequestDataPersistent
        extends PersistentBase
        implements Serializable
{
    protected String hobby;
    protected String aversion;

    public RequestDataPersistent() {
    }

    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    @NotNull
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    @NotNull
    public String getAversion() {
        return aversion;
    }

    public void setAversion(String aversion) {
        this.aversion = aversion;
    }

    protected int daysPerWeek;

    @Min(value=1, message="must be greater than 1, if this is a hobby.")
    @Max(value=7, message="cannot be greater than 7. A week only has 7 days.")
    public int getDaysPerWeek() {
        return daysPerWeek;
    }

    public void setDaysPerWeek(int daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }
}

