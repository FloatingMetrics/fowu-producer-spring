package com.fowu.strainproducer;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import com.fowu.common.KafkaConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class StrainConfig {

  @Autowired
  private KafkaConfig kafkaConfig;

  private final String topicName = "strain";

  @Bean
  public ProducerFactory<String, Strain> producerFactory() {
    Map<String, Object> props = new HashMap<>(kafkaConfig.producerProperties());

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
