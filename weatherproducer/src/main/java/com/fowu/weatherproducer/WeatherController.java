package com.fowu.weatherproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CompletableFuture;

@Controller
public class WeatherController {

  private final WeatherService weatherService;
  private WeatherData data;
  private final String topicName = "weather";
  private final String key = "w001";

  @Autowired
  private KafkaTemplate<String, Weather> kafkaTemplate;

  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  int i = 0;

  private Weather weatherDataPoints() {
    if (data == null)
      data = weatherService.getWeatherData();

    if (i >= data.waveHeight().length)
      i = 0;

    Weather weather = new Weather(
      data.captureTime()[i],
      data.waveHeight()[i],
      data.wavePeriod()[i],
      data.waveDirection()[i],
      data.windSpeed()[i],
      data.windDirection()[i]);

    i++;
    return weather;
  }

  @Scheduled(fixedDelay = 2000)
  public void send() {
    Weather pointData = weatherDataPoints();
    CompletableFuture<SendResult<String, Weather>> future = kafkaTemplate.send(topicName, key, pointData);
    future.whenComplete((result, ex) -> {
      if (ex == null) {
        System.out.println("Sent value=[" + result.getProducerRecord().value() +
                           "] topic=[" + result.getRecordMetadata().topic() +
                           "] partition=[" + result.getRecordMetadata().partition() +
                           "] offset=[" + result.getRecordMetadata().offset() +
                           "]");
      } else {
        System.out.println("Unable to send value=[" +
                           pointData + "] due to : " + ex.getMessage());
      }
    });
  }


}
