package ru.otus.bot.car.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Metrics {
    @Id
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "metric")
    @Enumerated(EnumType.STRING)
    private MetricType metricType;
    private String value;
    private LocalDate date;
}
