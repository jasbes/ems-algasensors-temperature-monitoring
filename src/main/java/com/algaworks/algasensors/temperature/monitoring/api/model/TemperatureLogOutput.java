package com.algaworks.algasensors.temperature.monitoring.api.model;

import com.algaworks.algasensors.temperature.monitoring.domain.model.TemperatureLog;
import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class TemperatureLogOutput {
    private UUID id;
    private TSID sensorId;
    private OffsetDateTime registeredAt;
    private Double value;

    public static TemperatureLogOutput fromEntity(TemperatureLog temperatureLog) {
        return TemperatureLogOutput.builder()
                .id(temperatureLog.getId().getValue())
                .value(temperatureLog.getValue())
                .registeredAt(temperatureLog.getRegisteredAt())
                .sensorId(temperatureLog.getSensorId().getValue())
                .build();
    }
}
