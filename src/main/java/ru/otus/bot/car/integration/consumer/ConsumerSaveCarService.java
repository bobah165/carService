package ru.otus.bot.car.integration.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.bot.car.repository.model.Car;
import ru.otus.bot.car.service.CarService;


@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerSaveCarService {

  private static final String topicTelegram = "${topic.consumer.car.save}";
  private static final String kafkaConsumerGroupId = "${spring.kafka.consumer.group-id}";
  private final CarService carService;

  @Transactional
  @KafkaListener(topics = topicTelegram, groupId = kafkaConsumerGroupId, properties = {"spring.json.value.default.type=ru.otus.bot.car.repository.model.Car"})
  public Car createOrder(Car metrics) {
    log.info("Message consumed {}", metrics);
    carService.save(metrics);
    return metrics;
  }
}
