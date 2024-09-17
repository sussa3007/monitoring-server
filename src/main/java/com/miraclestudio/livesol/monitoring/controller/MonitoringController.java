package com.miraclestudio.livesol.monitoring.controller;


import com.miraclestudio.livesol.monitoring.dto.MonitoringDataDto;
import com.miraclestudio.livesol.monitoring.service.MonitoringService;
import com.miraclestudio.livesol.user.dto.UserResponseDto;
import com.miraclestudio.livesol.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitoring")
@RequiredArgsConstructor
public class MonitoringController {

    private final UserService userService;

    private final MonitoringService monitoringService;

    @PostMapping("/data")
    public ResponseEntity<?> receiveMonitoringData(
            HttpServletRequest request,
            @RequestBody MonitoringDataDto data
    ) {
        // 모니터링 데이터 처리 (로그 출력 또는 저장)
        System.out.println("Received Monitoring Data: " + data);
        String key = request.getHeader("auth-key");
        // 키 틀리면 401로 응답
        UserResponseDto findUser = userService.findUserByKey(key);
        boolean monitoringData = monitoringService.createMonitoringData(data, findUser.getId());

        // 필요하다면 데이터베이스에 저장하거나 추가 처리
        return ResponseEntity.ok().build();
    }
}
