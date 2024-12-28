package ru.otus.bot.car.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.bot.car.data.Metrics;


@Service
@RequiredArgsConstructor
public class MetricsService {


    @Transactional
    public void save(Metrics metrics) {

    }



}
