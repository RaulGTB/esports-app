package rjkscore.application.service;

import rjkscore.Infrastructure.Dto.Request.RegisterRequestDto;
import rjkscore.Infrastructure.Dto.Response.AppUserResponseDto;

public interface AuthService {
    AppUserResponseDto register(RegisterRequestDto dto);
}
