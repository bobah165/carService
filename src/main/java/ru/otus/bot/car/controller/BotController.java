package ru.otus.bot.car.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.bot.car.repository.model.Car;
import ru.otus.bot.car.service.CarService;

@RestController
@RequiredArgsConstructor
public class BotController {

  private final CarService carService;

  @GetMapping(value = "${car.api.sub-path.id}")
  public ResponseEntity<Car> getCarById(@PathVariable("id") Long id){
    return ResponseEntity.ok(carService.findById(String.valueOf(id)));
  }
}
