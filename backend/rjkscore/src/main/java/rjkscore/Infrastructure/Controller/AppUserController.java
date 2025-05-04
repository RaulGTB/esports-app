package rjkscore.Infrastructure.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rjkscore.Infrastructure.Dto.Request.CoinsUpdateDto;
import rjkscore.Infrastructure.Dto.Request.UpdateUserDto;
import rjkscore.Infrastructure.Dto.Response.AppUserResponseDto;
import rjkscore.application.service.AppUserService;

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

    @PutMapping("/{userId}")
    public ResponseEntity<AppUserResponseDto> updateUser(@PathVariable Long userId, @RequestBody UpdateUserDto dto) {
        return ResponseEntity.ok(service.updateUser(userId, dto));
    }

    @PutMapping("/{userId}/coins")
    public ResponseEntity<AppUserResponseDto> updateCoins(@PathVariable long userId, @RequestBody CoinsUpdateDto coinsDto) {
        return ResponseEntity.ok(service.updateCoins(userId, coinsDto.getCoins()));

    }
    
}
