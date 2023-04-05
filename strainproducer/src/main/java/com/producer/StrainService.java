package com.producer;

public class StrainService {
  StrainGaugeSimulator simulator = new StrainGaugeSimulator();

  public StrainService() {
    simulator.setCurrentLevel(0);
  }

  public Strain getStrainData() {
    simulator.simulateStrain();
    return new Strain(simulator.getCurrentLevel());
  }
}
