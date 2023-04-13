package com.fowu.weatherproducer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherController {

  private final WeatherService weatherService;
  private WeatherData data;
  private final KafkaTemplate<String, Weather> kafkaTemplate;

  public WeatherController(WeatherService weatherService,
                           KafkaTemplate<String, Weather> kafkaTemplate) {
    this.weatherService = weatherService;
    this.kafkaTemplate = kafkaTemplate;
  }

  int i = 0;

  private Weather weatherDataPoints() {
    if (data == null)
      data = weatherService.getWeatherData();

    if (i >= data.waveHeight().length)
      i = 0;

    Weather weather = new Weather(
        data.time()[i],
        data.waveHeight()[i],
        data.wavePeriod()[i],
        data.waveDirection()[i],
        data.windSpeed()[i],
        data.windDirection()[i]);

    i++;
    return weather;
  }

  @Scheduled(fixedDelay = 500)
  public void send() {
    Weather pointData = weatherDataPoints();
    kafkaTemplate.send("weather", pointData);
    System.out.println(pointData);
  }

}
