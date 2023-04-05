package com.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

public class WeatherConfig {

  @Autowired
  private main.java.com.fowu.kafkaConfig kafkaConfig;

  @Value("${kafka.topicWeather}")
  private String topicName;

  @Bean
  public ProducerFactory<String, Weather> producerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.putAll(kafkaConfig.producerProperties());

    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              CustomSerializerWeather.class);
    return new DefaultKafkaProducerFactory<>(props);
  }

  @Bean
  public KafkaTemplate<String, Weather> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public String topic() {
    return topicName;
  }

}
