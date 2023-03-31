package com.fowu.fowuproducerspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;


// @Controller
// public class ProducerController {

//     @Autowired
//     private KafkaTemplate<String, Weather> kafkaTemplate;


//     private int random() {
//         return (int)(Math.random() * 20) + 1;
//     }

//     private Weather weatherData() {

//         double waveHeight = 3;
//         double wavePeriod = 12;
//         int waveDirection = 122;
//         double windSpeed = 8.5;
//         int windDirection = 188;

//         double[] additionalWaveHeight = {-0.1, -0.12, -0.15, -0.18, -0.2, -0.21, -0.25, -0.3, -0.35, -0.4, 0, 0.1, 0.12, 0.15, 0.18, 0.2, 0.21, 0.25, 0.3, 0.35, 0.4};
//         double[] additionalWavePeriodAndWindSpeed = {-0.2, -0.1, -0.3, -0.35, -0.4, -0.7, -1, -1.2, -0.6, 0, 0.7, 1.25, 0.1, 0.2, 0.35, 0.5, 0.67, 0.8, 1, 1.1, 0.9};
//         int[] additionalDirection = {1, 3, 5, 6, 8, 10, 12, 15, 17, 25, -1, -3, -5, -6, -10, -12, -15, -17, -20, -22, -25};

//         return new Weather(
//                 waveHeight + additionalWaveHeight[random()],
//                 wavePeriod + additionalWavePeriodAndWindSpeed[random()],
//                 waveDirection + additionalDirection[random()],
//                 windSpeed + additionalWavePeriodAndWindSpeed[random()],
//                 windDirection + additionalDirection[random()]
//         );
//     }

//     @Scheduled(cron = "*/10 * * * * *")
//     public void send() {
//         Weather data = weatherData();
//         kafkaTemplate.send("weather", data);
//         System.out.println(data.toString());
//     }

// }
