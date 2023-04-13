package com.fowu.strainproducer;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import com.fowu.common.kafkaConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class StrainConfig {

  @Autowired
  private kafkaConfig kafkaConfig;

  @Value("${kafka.topicStrain}")
  private String topicName;

  @Bean
  public ProducerFactory<String, Strain> producerFactory() {
    Map<String, Object> props = new HashMap<>(kafkaConfig.producerProperties());

    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              CustomSerializerStrain.class);
    return new DefaultKafkaProducerFactory<>(props);
  }

  @Bean
  public KafkaTemplate<String, Strain> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

  @Bean
  public String topic() {
    return topicName;
  }

}
