package com.san.auth.services;

import com.san.auth.models.UserAuthModel;
import com.san.auth.services.dao.UserAuthDaoFileImpl;
import com.san.auth.services.dto.UserDtlsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAuthServiceImpl implements UserAuthService {
    private final UserAuthDaoFileImpl userAuthDaoFile;

    @Autowired
    public UserAuthServiceImpl(UserAuthDaoFileImpl userAuthDaoFile) {
        this.userAuthDaoFile = userAuthDaoFile;
    }

    @Override
    public UserDtlsDto registerUser(final UserAuthModel userAuthModel) {
        return userAuthDaoFile.saveUserRegistrationData(userAuthModel);

    }

    @Override
    public UserDtlsDto loginUser(final UserAuthModel userAuthModel) {

        return userAuthDaoFile.loginUser(userAuthModel);
    }
}
