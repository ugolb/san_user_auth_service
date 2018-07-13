package com.auth.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserAuthModel {

    @Size(min=5, max=30)
    private String userName;

    @NotNull
    @Size(min=5, max=30)
    private String email;

    @NotNull
    @Size(min=5, max=30)
    private String password;
}
