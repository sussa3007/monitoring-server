package com.miraclestudio.livesol.monitoring.entity;

import com.miraclestudio.livesol.audit.Auditable;
import com.miraclestudio.livesol.monitoring.dto.MonitoringDataDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monitoring_data")
@Getter
@Setter
@Builder
public class MonitoringData extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private double cpuUsage;

    @Column(nullable = false)
    private double memoryUsage;

    @Column(nullable = false)
    private double networkUsage;

    @Column(nullable = false)
    private double uploadSpeed;

    @Column(nullable = false)
    private double downloadSpeed;

    public static MonitoringData create(Long userId, MonitoringDataDto dto) {
        return MonitoringData.builder()
                .userId(userId)
                .cpuUsage(dto.getCpuUsage())
                .memoryUsage(dto.getMemoryUsage())
                .networkUsage(dto.getNetworkUsage())
                .uploadSpeed(dto.getUploadSpeed())
                .downloadSpeed(dto.getDownloadSpeed())
                .build();
    }
}
