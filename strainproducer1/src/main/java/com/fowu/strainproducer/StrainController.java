package com.fowu.strainproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
public class StrainController {

  private final StrainService strainService;

  private final String topicName = "strain";

  private final String key1 = "str001";
  private final String key2 = "str002";
  private final String key3 = "str003";

  private final int partition1 = 0;
  private final int partition2 = 1;
  private final int partition3 = 2;

  @Autowired
  private KafkaTemplate<String, Strain> kafkaTemplate;

  public StrainController(StrainService strainService) {
    this.strainService = strainService;
  }

  @Scheduled(fixedDelay = 2000)
  public void send() {
//    Strain 1
        Strain data1 = strainService.getStrainData();
        CompletableFuture<SendResult<String, Strain>> future1 = kafkaTemplate.send(topicName, partition1, key1, data1);
        future1.whenComplete((result, ex) -> {
          if (ex == null) {
            System.out.println("Sent value=[" + result.getProducerRecord().value() +
                               "] key=[" + result.getProducerRecord().key() +
                               "] topic=[" + result.getRecordMetadata().topic() +
                               "] partition=[" + result.getRecordMetadata().partition() +
                               "] offset=[" + result.getRecordMetadata().offset() +
                               "]");
          } else {
            System.out.println("Unable to send value=[" +
                               data1 + "] due to : " + ex.getMessage());
          }
        });

    //    Strain 2
    Strain data2 = strainService.getStrainData();
    CompletableFuture<SendResult<String, Strain>> future2 = kafkaTemplate.send(topicName, partition2, key2, data2);
    future2.whenComplete((result, ex) -> {
      if (ex == null) {
        System.out.println("Sent value=[" + result.getProducerRecord().value() +
                           "] key=[" + result.getProducerRecord().key() +
                           "] topic=[" + result.getRecordMetadata().topic() +
                           "] partition=[" + result.getRecordMetadata().partition() +
                           "] offset=[" + result.getRecordMetadata().offset() +
                           "]");
      } else {
        System.out.println("Unable to send value=[" +
                           data2 + "] due to : " + ex.getMessage());
      }
    });

    //    Strain 3
    Strain data3 = strainService.getStrainData();
    CompletableFuture<SendResult<String, Strain>> future3 = kafkaTemplate.send(topicName, partition3, key3, data3);
    future3.whenComplete((result, ex) -> {
      if (ex == null) {
        System.out.println("Sent value=[" + result.getProducerRecord().value() +
                           "] key=[" + result.getProducerRecord().key() +
                           "] topic=[" + result.getRecordMetadata().topic() +
                           "] partition=[" + result.getRecordMetadata().partition() +
                           "] offset=[" + result.getRecordMetadata().offset() +
                           "]");
      } else {
        System.out.println("Unable to send value=[" +
                           data3 + "] due to : " + ex.getMessage());
      }
    });

  }
}
