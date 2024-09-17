package com.miraclestudio.livesol.monitoring.repository;

import com.miraclestudio.livesol.monitoring.entity.MonitoringData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoringDataJpaRepository extends JpaRepository<MonitoringData, Long> {
}
