package com.fowu.strainproducer;

public class StrainGaugeSimulator {

  private double currentLevel; // current strain gauge level

  // constructor that initializes the current level to 0
  public StrainGaugeSimulator() {
    currentLevel = 0;
  }

  // method that returns the current strain gauge level
  public double getCurrentLevel() {
    return currentLevel;
  }

  // method that sets the current strain gauge level to a specified value within
  // the range of -40 to 40 MPa
  public void setCurrentLevel(double level) {
    if (level < -40 || level > 40) {
      throw new IllegalArgumentException("Strain gauge level must be within -40 and 40 MPa");
    }
    currentLevel = level;
  }

  // method that simulates a change in the strain gauge level by adding a random
  // value between -2 and 2 MPa
  public void simulateStrain() {
    double randomChange = Math.random() * 4 - 2; // generates a random value between -2 and 2
    double newLevel = currentLevel + randomChange;
    if (newLevel < -40) {
      currentLevel = -40;
    } else if (newLevel > 40) {
      currentLevel = 40;
    } else {
      currentLevel = newLevel;
    }
  }
}
