package com.san.auth.services;

import com.san.auth.models.UserAuthModel;
import com.san.auth.services.dao.UserAuthDaoMySqlImpl;
import com.san.auth.services.dto.UserDtlsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAuthServiceImpl implements UserAuthService {
    private final UserAuthDaoMySqlImpl dao;

    @Autowired
    public UserAuthServiceImpl(UserAuthDaoMySqlImpl dao) {
        this.dao = dao;
    }

    @Override
    public UserDtlsDto registerUser(final UserAuthModel userAuthModel) {
        return dao.saveUserRegistrationData(userAuthModel);

    }

    @Override
    public UserDtlsDto loginUser(final UserAuthModel userAuthModel) {

        return dao.loginUser(userAuthModel);
    }
}
