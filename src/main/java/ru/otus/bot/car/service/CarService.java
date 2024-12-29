package ru.otus.bot.car.service;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.bot.car.integration.producer.CarPublisherService;
import ru.otus.bot.car.repository.CarRepository;
import ru.otus.bot.car.repository.model.Car;


@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarPublisherService carPublisherService;


    @Transactional
    public void save(Car car) {
        car.setId(UUID.randomUUID().toString());
        var savedCar = carRepository.save(car);
        carPublisherService.sendOrder(savedCar);
    }

    @Transactional(readOnly = true)
    public Car findById(String id) {
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

}
