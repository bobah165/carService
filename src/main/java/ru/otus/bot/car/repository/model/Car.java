package ru.otus.bot.car.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(schema = "general", name = "car")
@Accessors(chain = true)
@NoArgsConstructor
public class Car {
    @Id
    private String id;
    @Column(name = "chat_id")
    private String chatId;
    private String model;
    private int year;
    @Column(name = "engine_volume")
    private float engineVolume;
    private String transmission;
    private int mileage;
}
