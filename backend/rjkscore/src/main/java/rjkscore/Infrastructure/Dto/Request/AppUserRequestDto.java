package rjkscore.Infrastructure.Dto.Request;

import lombok.Data;

@Data
public class AppUserRequestDto {
    private String username;
    private String email;
    private String password;

}
