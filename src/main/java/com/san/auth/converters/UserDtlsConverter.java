package com.san.auth.converters;

import com.san.auth.entities.User;
import com.san.auth.models.UserRegistrationModel;
import com.san.common.encrypt.Encryptor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserDtlsConverter {

    public User convertToUserEntity(final UserRegistrationModel model) {
        String userName = model.getUserName();
        String email = model.getEmail();
        String password = model.getPassword();
        new Encryptor().decrypt(password);

        return new User(userName, email, password, LocalDateTime.now());
    }
}
