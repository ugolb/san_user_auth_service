package sanduku.san_user_auth_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sanduku.san_user_auth_service.models.UserAuthModel;
import sanduku.san_user_auth_service.services.dto.UserDtlsDto;

@RequestMapping(value = "/battleship")
public interface UserAuthApi {

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<UserDtlsDto> loginUser(@RequestBody UserAuthModel userAuthModel);

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<UserDtlsDto> registerUser(@RequestBody UserAuthModel userAuthModel);
}
