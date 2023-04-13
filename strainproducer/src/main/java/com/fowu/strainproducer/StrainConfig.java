package com.fowu.strainproducer;

import com.fowu.common.KafkaConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Import(KafkaConfig.class)
public class StrainConfig {

  @Autowired
  private KafkaConfig kafkaConfig;

  @Autowired
  private CustomSerializerStrain customSerializerStrain;

  private final String topicName = "strain";

  @Bean
  public ProducerFactory<String, Strain> producerFactory() {
    Map<String, Object> props = new HashMap<>(kafkaConfig.producerProperties());

    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
              customSerializerStrain.getClass());
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
