package com.san.auth.controllers;
import com.san.auth.models.UserLoginModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.san.auth.models.UserRegistrationModel;
import com.san.auth.services.dto.UserDtlsDto;

@RequestMapping(value = "/battleship")
public interface UserAuthApi {

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<UserDtlsDto> loginUser(@RequestBody UserLoginModel userLoginModel);

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<UserDtlsDto> registerUser(@RequestBody UserRegistrationModel userRegistrationModel);
}
