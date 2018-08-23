package com.san.auth.services.dao;

import com.san.auth.models.UserLoginModel;
import com.san.auth.models.UserRegistrationModel;
import com.san.auth.services.dto.UserDtlsDto;

public interface UserAuthDao {

    /**
     * Save user registration date to data store
     *
     * @param userRegistrationModel object which contains user registration information received from client.
     * @see UserDtlsDto object.
     */
    UserDtlsDto saveUserRegistrationData(final UserRegistrationModel userRegistrationModel);

    /**
     * Check if user could be logged in
     *
     * @param userLoginModel object which contains user registration information received from client.
     * @see UserDtlsDto object.
     */
    UserDtlsDto loginUser(final UserLoginModel userLoginModel);
}
