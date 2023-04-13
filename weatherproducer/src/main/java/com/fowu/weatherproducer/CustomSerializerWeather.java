package com.fowu.weatherproducer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomSerializerWeather implements Serializer<Weather> {

  private final ObjectMapper objectMapper;

  public CustomSerializerWeather() {
    // Initialize ObjectMapper with custom serialization settings
    this.objectMapper = new ObjectMapper();
    this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,
                                false);
  }

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
  }

  @Override
  public byte[] serialize(String topic, Weather data) {
    try {
      if (data == null) {
        System.out.println("Null received at serializing");
        return null;
      }
      return objectMapper.writeValueAsBytes(data);
    } catch (Exception e) {
      throw new SerializationException(
        "Error when serializing to byte[]: " + data, e);
    }
  }

  @Override
  public void close() {
  }

}
