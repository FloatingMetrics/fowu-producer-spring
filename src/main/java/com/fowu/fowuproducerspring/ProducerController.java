package com.fowu.fowuproducerspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class ProducerController {

  private final WeatherService weatherService;
  private WeatherData data;

  @Autowired
  private KafkaTemplate<String, Weather> kafkaTemplate;

  public ProducerController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  int i = 0;
  private Weather weatherDataPoints() {
    if (data == null)
      data = weatherService.getWeatherData();

    if (i > 167) i = 0;

    return new Weather(
        data.waveHeight().get(++i),
        data.wavePeriod().get(++i),
        data.waveDirection().get(++i),
        data.windSpeed().get(++i),
        data.windDirection().get(++i));
  }

  @Scheduled(fixedDelay = 2000)
  public void send() {
      Weather pointData = weatherDataPoints();
      kafkaTemplate.send("weather", pointData);
      System.out.println(pointData.toString());
  }

}
