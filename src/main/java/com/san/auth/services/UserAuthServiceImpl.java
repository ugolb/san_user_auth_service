package com.san.auth.services;

import com.san.auth.models.UserLoginModel;
import com.san.auth.models.UserRegistrationModel;
import com.san.auth.services.dao.UserAuthDaoMySqlImpl;
import com.san.auth.services.dto.UserDtlsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
public class UserAuthServiceImpl implements UserAuthService {
    private final UserAuthDaoMySqlImpl dao;

    @Autowired
    public UserAuthServiceImpl(UserAuthDaoMySqlImpl dao) {
        this.dao = dao;
    }

    @Override
    public UserDtlsDto registerUser(final UserRegistrationModel userRegistrationModel) {
        return dao.saveUserRegistrationData(userRegistrationModel);

    }

    @Override
    public UserDtlsDto loginUser(final UserLoginModel userLoginModel) {
        return dao.loginUser(userLoginModel);
    }
}
