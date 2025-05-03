package rjkscore.Application.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import rjkscore.Application.Mapper.AppUserMapper;
import rjkscore.Application.Service.AppUserService;
import rjkscore.Infrastructure.Dto.Response.AppUserResponseDto;
import rjkscore.Infrastructure.Repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository repository;
    private final AppUserMapper mapper;

    public AppUserServiceImpl(AppUserRepository repository, AppUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<AppUserResponseDto> getAllUsers(){
        return repository.findAll().stream()
            .map(mapper::toResponseDto)
            .toList();
    }

    @Override
    public AppUserResponseDto getUserById(Long userId) {
        return repository.findById(userId)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
