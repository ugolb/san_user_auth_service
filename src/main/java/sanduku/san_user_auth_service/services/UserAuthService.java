package sanduku.san_user_auth_service.services;

import sanduku.san_user_auth_service.models.UserAuthModel;
import sanduku.san_user_auth_service.services.dto.UserDtlsDto;

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
