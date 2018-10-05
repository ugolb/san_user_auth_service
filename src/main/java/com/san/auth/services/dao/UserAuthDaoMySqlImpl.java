package com.san.auth.services.dao;

import com.san.auth.converters.UserDtlsConverter;
import com.san.auth.entities.User;
import com.san.auth.exceptions.UserAlreadyExistException;
import com.san.auth.exceptions.UserDuplicateException;
import com.san.auth.models.UserLoginModel;
import com.san.auth.models.UserRegistrationModel;
import com.san.auth.repositories.UserRepository;
import com.san.auth.services.dto.UserDtlsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAuthDaoMySqlImpl implements UserAuthDao {
    private static final int FIRST_ELEMENT = 0;
    private static final String USER_DUPLICATE_EXCEPTION = "More then one user has %s email. " +
            "Email should be unique value.";
    private static final String USER_ALREADY_EXIST_EXCEPTION = "User already exist.";
    private static final String USER_DOES_NOT_EXIST_EXCEPTION = "User does not exist.";
    private static final String WRONG_LOGIN_DATA_EXCEPTION = "User login or password is wrong.";
    private UserRepository userRepository;
    private UserDtlsConverter converter;

    @Autowired
    public UserAuthDaoMySqlImpl(UserRepository userRepository, UserDtlsConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public UserDtlsDto saveUserRegistrationData(UserRegistrationModel userRegistrationModel) {
        final List<User> users = getUserByEmail(userRegistrationModel.getEmail());

        if (users.isEmpty()) {
            final User user = converter.convertToUserEntity(userRegistrationModel);
            userRepository.save(user);
            return UserDtlsDto.builder()
                    .userId(user.getId())
                    .userName(user.getUserName())
                    .build();
        } else {
            throw new UserAlreadyExistException(USER_ALREADY_EXIST_EXCEPTION);
        }
    }

    @Override
    public UserDtlsDto loginUser(final UserLoginModel userLoginModel) {
        List<User> users = getUserByEmail(userLoginModel.getLogin());

        if (users.isEmpty()) {
            throw new IllegalArgumentException(USER_DOES_NOT_EXIST_EXCEPTION);
        }

        final User user = users.get(FIRST_ELEMENT);
        validateUserInputValue(userLoginModel, user);

        return UserDtlsDto.builder()
                .userName(user.getUserName())
                .userId(user.getId())
                .build();
    }

    private void validateUserInputValue(UserLoginModel userLoginModel, User user) {
        if (!userLoginModel.getLogin().equals(user.getEmail())
                || !userLoginModel.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException(WRONG_LOGIN_DATA_EXCEPTION);
        }
    }

    private List<User> getUserByEmail(String email) {
        final List<User> users = userRepository.findByEmail(email);

        if (users.size() > 1) {
            throw new UserDuplicateException(String.format(USER_DUPLICATE_EXCEPTION, email));
        }
        return users;
    }
}
