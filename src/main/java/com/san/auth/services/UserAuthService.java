package com.san.auth.services;

import com.san.auth.models.UserLoginModel;
import com.san.auth.models.UserRegistrationModel;
import com.san.auth.services.dto.UserDtlsDto;

public interface UserAuthService {

    /**
     * Method implements user registration process
     * @param userRegistrationModel input parameters from client side
     * @return UserDtlsDto object
     */
    UserDtlsDto registerUser(final UserRegistrationModel userRegistrationModel);

    /**
     * Method implements user login process
     * @param userLoginModel input parameters from client side
     * @return UserDtlsDto object
     */
    UserDtlsDto loginUser (final UserLoginModel userLoginModel);
}
