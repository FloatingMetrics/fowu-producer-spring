package com.fowu.fowuproducerspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
  private final WeatherService weatherService;

  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping("/")
  public WeatherData getWeatherData() {
    return weatherService.getWeatherData();
  }
  
}
