package com.auth.services;

import com.auth.models.UserAuthModel;
import com.auth.services.dto.UserDtlsDto;

public interface UserAuthService {

    /**
     * Method implements user registration process
     * @param userAuthModel input parameters from client side
     * @return UserDtlsDto object
     */
    UserDtlsDto registerUser(final UserAuthModel userAuthModel);

    /**
     * Method implements user login process
     * @param userAuthModel input parameters from client side
     * @return UserDtlsDto object
     */
    UserDtlsDto loginUser (final UserAuthModel userAuthModel);
}
