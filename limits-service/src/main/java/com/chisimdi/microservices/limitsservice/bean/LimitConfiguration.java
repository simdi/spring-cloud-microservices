package com.chisimdi.microservices.limitsservice.bean;

public class LimitConfiguration {
  private int minimum;
  private int maximum;

  protected LimitConfiguration() {}

  public LimitConfiguration(int min, int max) {
    super();
    this.minimum = min;
    this.maximum = max;
  }

  public int getMinimum() {
    return minimum;
  }

  public void setMinimum(int minimum) {
    this.minimum = minimum;
  }

  public int getMaximum() {
    return maximum;
  }

  public void setMaximum(int maximum) {
    this.maximum = maximum;
  }
}