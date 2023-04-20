package com.fowu.strainproducer;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Strain implements Serializable {
  String time;
  double strain;
  Instant instant = Instant.now();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.of("GMT+2"));

  public Strain(double strain) {
    this.time = formatter.format(instant);
    this.strain = strain;
  }

  @Override
  public String toString() {
    return "Strain{" +
           "time=" + time +
           ", strain=" + strain +
           '}';
  }

}
