package ru.otus.bot.car.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.bot.car.data.MetricType;
import ru.otus.bot.car.data.Metrics;
import ru.otus.bot.car.repository.CarRepository;
import ru.otus.bot.car.repository.model.Car;


@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final MetricsService metricsService;

    @Transactional
    public void save(Car car) {
        setInitialMileage(car);
        car.setId(UUID.randomUUID().toString());
        carRepository.save(car);
    }

    @Transactional(readOnly = true)
    public Car findById(Long id) {
        return carRepository.findByChatId(String.valueOf(id))
                            .orElse(new Car().setId("no car"));
    }

    @Transactional(readOnly = true)
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }


    @Transactional(readOnly = true)
    public List<Car> findCarsByMileage(int from, int to) {
        return carRepository.findByMileageBetween(from, to);
    }

    private void setInitialMileage(Car car) {
        metricsService.save(new Metrics().setMetricType(MetricType.MILEAGE)
                                         .setDate(LocalDate.now())
                                         .setValue(String.valueOf(car.getMileage()))
                                         .setUserId(car.getId()));
    }
}
