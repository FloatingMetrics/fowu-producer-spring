package com.fowu.strainproducer;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Strain implements Serializable {
  String captureTime;
  double strain;
  Instant instant = Instant.now();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.of("GMT+2"));

  public String getCaptureTime() {
    return captureTime;
  }

  public double getStrain() {
    return strain;
  }

  public Strain(double strain) {
    this.captureTime = formatter.format(instant);
    this.strain = strain;
  }

  @Override
  public String toString() {
    return "Strain{" +
           "captureTime=" + captureTime +
           ", strain=" + strain +
           '}';
  }

}
