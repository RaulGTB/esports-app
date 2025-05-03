package rjkscore.Application.Service;

import java.util.List;

import rjkscore.Infrastructure.Dto.Response.AppUserResponseDto;

public interface AppUserService {
    List<AppUserResponseDto> getAllUsers();

    AppUserResponseDto getUserById(Long userId);
}