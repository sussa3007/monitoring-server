package com.miraclestudio.livesol.user.service;

import com.miraclestudio.livesol.constant.ErrorCode;
import com.miraclestudio.livesol.exception.ServiceLogicException;
import com.miraclestudio.livesol.user.dto.UserResponseDto;
import com.miraclestudio.livesol.user.entity.User;
import com.miraclestudio.livesol.user.repository.UserJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public UserResponseDto findUserByKey(String apiKey) {
        User findUser = userJpaRepository.findByApiKey(apiKey)
                .orElseThrow(() -> new ServiceLogicException(ErrorCode.NO_PERMISSIONS));
        return UserResponseDto.of(findUser);
    }
}
