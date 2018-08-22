package com.san.auth.services.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDtlsDto {
    private String userName;
    private Long userId;

}
