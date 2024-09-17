package com.miraclestudio.livesol.monitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonitoringDataDto {
    private double cpuUsage;
    private double memoryUsage;
    private double networkUsage;
    private double uploadSpeed;
    private double downloadSpeed;
    private List<DiskUsage> diskUsage;


    @Override
    public String toString() {
        return "MonitoringData{" +
                "cpuUsage=" + cpuUsage +
                ", memoryUsage=" + memoryUsage +
                ", networkUsage=" + networkUsage +
                ", uploadSpeed=" + uploadSpeed +
                ", downloadSpeed=" + downloadSpeed +
                ", diskUsage=" + diskUsage +
                '}';
    }

}