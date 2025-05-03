package rjkscore.Infrastructure.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rjkscore.Application.Service.AppUserService;
import rjkscore.Infrastructure.Dto.Response.AppUserResponseDto;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService service;
    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<AppUserResponseDto> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{userId}")
    public AppUserResponseDto getUserById(@PathVariable Long userId) {
        return service.getUserById(userId);
    }
    
}
