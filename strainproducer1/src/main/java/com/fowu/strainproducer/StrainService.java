package com.fowu.strainproducer;

import org.springframework.stereotype.Service;

@Service
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
