package ru.otus.bot.car.integration.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.otus.bot.car.repository.model.Car;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarPublisherService {

  @Value("${topic.producer.car-created}")
  private String sendClientTopic;

  private final KafkaTemplate<String , Object> kafkaTemplate;

  public void sendOrder(Car car) {
    kafkaTemplate.send(sendClientTopic, car.getId(), car);
    log.info("Send car created from producer {}", car);
  }

}
