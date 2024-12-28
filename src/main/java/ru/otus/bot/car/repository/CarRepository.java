package ru.otus.bot.car.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.bot.car.repository.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    List<Car> findByMileageBetween(int from, int to);
    Optional<Car> findByChatId(String chatId);

}
