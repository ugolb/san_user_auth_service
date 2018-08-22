package com.san.auth.models;

import com.san.common.encrypt.Encryptor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserAuthModel {
    private final Encryptor encryptor = new Encryptor();

    @Size(min = 5, max = 30)
    private String userName;

    @NotNull
//    @Size(min = 5, max = 60)
    private String email;

    @NotNull
//    @Size(min = 5, max = 60)
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = encryptor.encrypt(email);
    }

    public void setPassword(String password) {
        this.password = encryptor.encrypt(password);
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
