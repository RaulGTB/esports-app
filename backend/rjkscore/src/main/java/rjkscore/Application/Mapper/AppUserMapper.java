package rjkscore.Application.Mapper;

import rjkscore.Domain.AppUser;
import rjkscore.Infrastructure.Dto.Request.AppUserRequestDto;
import rjkscore.Infrastructure.Dto.Response.AppUserResponseDto;

public class AppUserMapper {
    public AppUserResponseDto toResponseDto (AppUser user){
        if (user == null) return null;

        return AppUserResponseDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .coins(user.getCoins())
                .build();
    }

    public AppUser toEntity (AppUserRequestDto dto){
        if (dto == null) return null;

        return AppUser.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .coins(1000)
                .build();
    }
}
