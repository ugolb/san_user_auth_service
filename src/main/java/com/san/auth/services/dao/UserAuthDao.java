package com.san.auth.services.dao;

import com.san.auth.models.UserAuthModel;
import com.san.auth.services.dto.UserDtlsDto;

public interface UserAuthDao {

    /**
     * This method goes to user data store and checks if user already exist.
     *
     * @return true if user exist false otherwise.
     */
    boolean isUserExist(String email);

    /**
     * Save user registration date to data store
     *
     * @param userAuthModel object which contains user registration information received from client.
     * @see UserDtlsDto object.
     */
    UserDtlsDto saveUserRegistrationData(final UserAuthModel userAuthModel);

    /**
     * Check if user could be logged in
     *
     * @param userAuthModel object which contains user registration information received from client.
     * @see UserDtlsDto object.
     */
    UserDtlsDto loginUser(final UserAuthModel userAuthModel);
}
