package com.fowu.strainproducer;

public class StrainGaugeSimulator {

  private double currentLevel; // current strain gauge level

  private final int stdDev = 20;

  // constructor that initializes the current level to 0
  public StrainGaugeSimulator() {
    currentLevel = 0;
  }

  // method that returns the current strain gauge level
  public double getCurrentLevel() {
    return currentLevel;
  }

  public void simulateStrain() {
    java.util.Random r = new java.util.Random();
    currentLevel = r.nextGaussian() * stdDev;
  }
}
