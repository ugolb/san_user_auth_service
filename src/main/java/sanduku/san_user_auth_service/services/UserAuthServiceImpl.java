package sanduku.san_user_auth_service.services;

import org.springframework.stereotype.Component;
import sanduku.san_user_auth_service.models.UserAuthModel;
import sanduku.san_user_auth_service.services.dto.UserDtlsDto;

@Component
public class UserAuthServiceImpl implements UserAuthService{

    @Override
    public UserDtlsDto registerUser(final UserAuthModel userAuthModel) {
        return null;
    }

    @Override
    public UserDtlsDto loginUser(final UserAuthModel userAuthModel) {

        return null;
    }
}
