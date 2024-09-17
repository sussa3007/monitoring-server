package com.miraclestudio.livesol.monitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiskUsage {

    private String drive;

    private String totalSpace;

    private String freeSpace;

    private String usagePercentage;

}
