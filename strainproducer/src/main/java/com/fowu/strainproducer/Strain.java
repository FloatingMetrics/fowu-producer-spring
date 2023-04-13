package com.fowu.strainproducer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Strain implements Serializable {
  String time;
  double strain;
  LocalDateTime localDateTime = LocalDateTime.now();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ss");

  public Strain(double strain) {
    this.time = localDateTime.format(formatter);
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
