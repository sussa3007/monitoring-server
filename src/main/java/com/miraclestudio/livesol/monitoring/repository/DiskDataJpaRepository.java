package com.miraclestudio.livesol.monitoring.repository;

import com.miraclestudio.livesol.monitoring.entity.DiskData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiskDataJpaRepository extends JpaRepository<DiskData, Long> {
}
