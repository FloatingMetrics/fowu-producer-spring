package com.fowu.weatherproducer;

import java.util.HashMap;
import java.util.Map;

import com.fowu.common.KafkaConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@Import(KafkaConfig.class)
public class WeatherConfig {

  private final String topicName = "weather";

  @Autowired
  private KafkaConfig kafkaConfig;

  @Autowired
  private CustomSerializerWeather customSerializerWeather;

  @Bean
  public ProducerFactory<String, Weather> producerFactory() {
    Map<String, Object> props = new HashMap<>(kafkaConfig.producerProperties());

    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              customSerializerWeather.getClass());
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
