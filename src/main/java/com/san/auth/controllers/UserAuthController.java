package com.san.auth.controllers;

import com.san.auth.models.UserLoginModel;
import com.san.auth.models.UserRegistrationModel;
import com.san.auth.services.UserAuthServiceImpl;
import com.san.auth.services.dto.UserDtlsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserAuthController implements UserAuthApi {

    private final UserAuthServiceImpl userAuthServiceImpl;

    @Autowired
    public UserAuthController(UserAuthServiceImpl userAuthServiceImpl) {
        this.userAuthServiceImpl = userAuthServiceImpl;
    }

    @Override
    public ResponseEntity<UserDtlsDto> loginUser(@Valid @RequestBody UserLoginModel userLoginModel) {
        return ResponseEntity.ok(userAuthServiceImpl.loginUser(userLoginModel));
    }

    @Override
    public ResponseEntity<UserDtlsDto> registerUser(@Valid @RequestBody UserRegistrationModel userRegistrationModel) {
        return ResponseEntity.ok(userAuthServiceImpl.registerUser(userRegistrationModel));
    }
}
