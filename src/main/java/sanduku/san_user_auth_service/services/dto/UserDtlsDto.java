package sanduku.san_user_auth_service.services.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDtlsDto {
    private String userName;
    private int userId;

}
