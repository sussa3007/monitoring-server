package com.miraclestudio.livesol.user.dto;

import com.miraclestudio.livesol.constant.Authority;
import com.miraclestudio.livesol.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Long id;

    private String username;
    
    private String email;

    private String password;

    private String apiKey;

    private boolean active;

    private Authority authority;
    
    public static UserResponseDto of(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .apiKey(user.getApiKey())
                .active(user.isActive())
                .authority(user.getAuthority())
                .build();
    }
    
}
