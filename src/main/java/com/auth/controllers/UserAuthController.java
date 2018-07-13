package com.auth.controllers;

import com.auth.models.UserAuthModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.auth.services.dto.UserDtlsDto;
import com.auth.services.UserAuthServiceImpl;

import javax.validation.Valid;

@RestController
public class UserAuthController implements UserAuthApi {

    private final UserAuthServiceImpl userAuthServiceImpl;

    @Autowired
    public UserAuthController(UserAuthServiceImpl userAuthServiceImpl) {
        this.userAuthServiceImpl = userAuthServiceImpl;
    }

    @Override
    public ResponseEntity<UserDtlsDto> loginUser(@Valid @RequestBody UserAuthModel userAuthModel) {
        return ResponseEntity.ok(userAuthServiceImpl.loginUser(userAuthModel));
    }

    @Override
    public ResponseEntity<UserDtlsDto> registerUser(@Valid @RequestBody UserAuthModel userAuthModel) {
        return ResponseEntity.ok(userAuthServiceImpl.registerUser(userAuthModel));
    }
}
