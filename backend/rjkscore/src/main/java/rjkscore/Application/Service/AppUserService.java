package rjkscore.application.service;

import java.util.List;

import rjkscore.Infrastructure.Dto.Request.UpdateUserDto;
import rjkscore.Infrastructure.Dto.Response.AppUserResponseDto;

public interface AppUserService {
    List<AppUserResponseDto> getAllUsers();

    AppUserResponseDto getUserById(Long userId);

    AppUserResponseDto updateUser(Long userId, UpdateUserDto dto);
    AppUserResponseDto updateCoins(Long userId, int newCoins); 
}