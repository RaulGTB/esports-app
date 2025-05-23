package rjkscore.application.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rjkscore.Domain.AppUser;
import rjkscore.Infrastructure.Dto.Request.RegisterRequestDto;
import rjkscore.Infrastructure.Dto.Response.AppUserResponseDto;
import rjkscore.Infrastructure.Repository.AppUserRepository;
import rjkscore.application.mapper.AppUserMapper;
import rjkscore.application.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AppUserRepository appUserRepository, AppUserMapper appUserMapper, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appUserMapper = appUserMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUserResponseDto register(RegisterRequestDto dto) {
       if (appUserRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }

        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        AppUser newUser = appUserMapper.toEntity(dto, hashedPassword);
        appUserRepository.save(newUser);

        return appUserMapper.toResponseDto(newUser);
    }

}
