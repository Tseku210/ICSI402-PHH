package com.example.phhch7.accountLogin;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
public class RequestDataAccount extends shared.PersistentBase implements Serializable {

    protected String hobby;
    protected String aversion;
    protected String accountNumber;

    public RequestDataAccount() {
    }

    @Pattern(regexp="[a-zA-Z]{2}\\d{3}",
            message="must be in the format AA999.")
    @NotNull
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Pattern(regexp=".*[^\\s].*", message="cannot be empty")
    @NotNull
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Pattern(regexp=".*[^\\s].*", message="cannot be empty")
    @NotNull
    public String getAversion() {
        return aversion;
    }

    public void setAversion(String aversion) {
        this.aversion = aversion;
    }
}