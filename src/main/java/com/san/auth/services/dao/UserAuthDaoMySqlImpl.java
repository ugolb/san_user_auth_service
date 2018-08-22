package com.san.auth.services.dao;

import com.san.auth.converters.UserDtlsConverter;
import com.san.auth.entities.User;
import com.san.auth.exceptions.UserAlreadyExistException;
import com.san.auth.exceptions.UserDuplicateException;
import com.san.auth.models.UserAuthModel;
import com.san.auth.repositories.UserRepository;
import com.san.auth.services.dto.UserDtlsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAuthDaoMySqlImpl implements UserAuthDao {
    private static final String USER_DUPLICATE_EXCEPTION = "More then one user has %s email. Email should be unique value.";
    private static final String USER_ALREADY_EXIST_EXCEPTION = "User with \"%s\" email already exist.";
    private UserRepository userRepository;
    private UserDtlsConverter converter;

    @Autowired
    public UserAuthDaoMySqlImpl(UserRepository userRepository, UserDtlsConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public boolean userIsNotExist(String email) {
        final List<User> users = userRepository.findByEmail(email);

        if (users.size() > 1) {
            throw new UserDuplicateException(String.format(USER_DUPLICATE_EXCEPTION, email));
        }

        return users.isEmpty();
    }

    @Override
    public UserDtlsDto saveUserRegistrationData(UserAuthModel userAuthModel) {
        if (userIsNotExist(userAuthModel.getEmail())) {
            User user = converter.convertToUserEntity(userAuthModel);
            userRepository.save(user);
            return UserDtlsDto.builder()
                    .userId(user.getId())
                    .userName(user.getUserName())
                    .build();
        } else {
            throw new UserAlreadyExistException(String.format(USER_ALREADY_EXIST_EXCEPTION, userAuthModel.getEmail()));
        }
    }

    @Override
    public UserDtlsDto loginUser(UserAuthModel userAuthModel) {
        return null;
    }
}
