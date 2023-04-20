package com.fowu.strainproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CompletableFuture;

@Controller
public class StrainController {

  private final StrainService strainService;

  private final String topicName = "strain";
  private final String key = "str001";

  @Autowired
  private KafkaTemplate<String, Strain> kafkaTemplate;

  public StrainController(StrainService strainService) {
    this.strainService = strainService;
  }

  @Scheduled(fixedDelay = 2000)
  public void send() {
    Strain data = strainService.getStrainData();
    CompletableFuture<SendResult<String, Strain>> future = kafkaTemplate.send(topicName, key, data);
    future.whenComplete((result, ex) -> {
      if (ex == null) {
        System.out.println("Sent value=[" + result.getProducerRecord().value() +
                           "] topic=[" + result.getRecordMetadata().topic() +
                           "] partition=[" + result.getRecordMetadata().partition() +
                           "] offset=[" + result.getRecordMetadata().offset() +
                           "]");
      } else {
        System.out.println("Unable to send value=[" +
                           data + "] due to : " + ex.getMessage());
      }
    });
  }

}
