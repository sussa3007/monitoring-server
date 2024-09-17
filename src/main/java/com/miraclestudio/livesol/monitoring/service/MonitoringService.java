package com.miraclestudio.livesol.monitoring.service;

import com.miraclestudio.livesol.monitoring.dto.DiskUsage;
import com.miraclestudio.livesol.monitoring.dto.MonitoringDataDto;
import com.miraclestudio.livesol.monitoring.entity.DiskData;
import com.miraclestudio.livesol.monitoring.entity.MonitoringData;
import com.miraclestudio.livesol.monitoring.repository.DiskDataJpaRepository;
import com.miraclestudio.livesol.monitoring.repository.MonitoringDataJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MonitoringService {

    private final MonitoringDataJpaRepository monitoringDataJpaRepository;

    private final DiskDataJpaRepository diskDataJpaRepository;

    public MonitoringDataDto getMonitoringData() {
        // CPU, 메모리, 네트워크 사용량을 가져오는 로직 구현
        MonitoringDataDto data = new MonitoringDataDto();
        data.setCpuUsage(50.0);  // 예시로 고정된 데이터
        data.setMemoryUsage(70.0);
        data.setNetworkUsage(30.0);
        return data;
    }

    public boolean createMonitoringData(MonitoringDataDto data, Long userId) {
        try {
            MonitoringData crateData = MonitoringData.create(userId, data);
            MonitoringData saveData = monitoringDataJpaRepository.save(crateData);
            for (DiskUsage disk : data.getDiskUsage()) {
                DiskData createDisk = DiskData.create(disk, saveData.getId());
                DiskData saveDisk = diskDataJpaRepository.save(createDisk);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }

    }

}