package com.fowu.fowuproducerspring.strain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class StrainController {

  private final StrainService strainService;

  @Autowired
  private KafkaTemplate<String, Strain> kafkaTemplate;

  public StrainController(StrainService strainService) {
    this.strainService = strainService;
  }

  @Scheduled(fixedDelay = 2000)
  public void send() {
    Strain data = strainService.getStrainData();
    kafkaTemplate.send("strain", data);
    System.out.println(data.toString());
  }

}
