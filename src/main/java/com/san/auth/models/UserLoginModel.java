package com.san.auth.models;

import javax.validation.constraints.NotNull;

public class UserLoginModel extends UserModelParent{

    @NotNull
//    @Size(min = 5, max = 60)
    private String email;

    @NotNull
//    @Size(min = 5, max = 60)
    private String password;

    public void setEmail(String email) {
        this.email = encryptor.encrypt(email.toLowerCase());
    }

    public void setPassword(String password) {
        this.password = encryptor.encrypt(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
