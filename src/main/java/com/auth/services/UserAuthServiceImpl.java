package com.auth.services;
import com.auth.models.UserAuthModel;
import com.auth.services.dto.UserDtlsDto;
import org.springframework.stereotype.Component;

@Component
public class UserAuthServiceImpl implements UserAuthService{

    @Override
    public UserDtlsDto registerUser(final UserAuthModel userAuthModel) {

        return UserDtlsDto.builder()
                .userId(1)
                .userName(userAuthModel.getUserName())
                .build();
    }

    @Override
    public UserDtlsDto loginUser(final UserAuthModel userAuthModel) {
//        Encryptor
        return UserDtlsDto.builder()
                .userId(1)
                .userName(userAuthModel.getUserName())
                .build();
    }
}
