package com.miraclestudio.livesol.monitoring.entity;

import com.miraclestudio.livesol.audit.Auditable;
import com.miraclestudio.livesol.monitoring.dto.DiskUsage;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "disk_data")
@Getter
@Setter
@Builder
public class DiskData extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long monitoringDataId;

    @Column(nullable = false)
    private String drive;

    @Column(nullable = false)
    private String totalSpace;

    @Column(nullable = false)
    private String freeSpace;

    @Column(nullable = false)
    private String usagePercentage;
    
    public static DiskData create(DiskUsage diskUsage, Long monitoringDataId) {
        return DiskData.builder()
                .monitoringDataId(monitoringDataId)
                .drive(diskUsage.getDrive())
                .totalSpace(diskUsage.getTotalSpace())
                .freeSpace(diskUsage.getFreeSpace())
                .usagePercentage(diskUsage.getUsagePercentage())
                .build();
    }

}
