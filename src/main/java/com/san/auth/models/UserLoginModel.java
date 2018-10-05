package com.san.auth.models;

import javax.validation.constraints.NotNull;

public class UserLoginModel extends UserModelParent{

    @NotNull
//    @Size(min = 5, max = 60)
    private String login;

    @NotNull
//    @Size(min = 5, max = 60)
    private String password;

    public void setLogin(String login) {
        this.login = encryptor.encrypt(login.toLowerCase());
    }

    public void setPassword(String password) {
        this.password = encryptor.encrypt(password);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
