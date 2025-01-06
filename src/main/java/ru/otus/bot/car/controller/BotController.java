package ru.otus.bot.car.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.bot.car.repository.model.Car;
import ru.otus.bot.car.service.CarService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BotController {

  private final CarService carService;

  @GetMapping(value = "${car.api.sub-path.id}")
  public ResponseEntity<Car> getCarById(@PathVariable("id") Long id){
    log.info("Get request from bot for id {}", id);
    return ResponseEntity.ok(carService.findById(String.valueOf(id)));
  }

  @GetMapping("/hello")
  public ResponseEntity hello() {
    log.info("Get request from bot for id {}");
    return ResponseEntity.ok("hello from car");
  }
}
