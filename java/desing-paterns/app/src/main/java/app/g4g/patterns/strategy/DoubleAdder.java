package app.g4g.patterns.strategy;

import java.util.Collection;

public class DoubleAdder {

  private Adder<Double> adder;

  public void setAdder(Adder<Double> adder) {
    this.adder = adder;
  }

  public Double add(Collection<Double> listOfDouble) {
    return adder.add(listOfDouble);
  }
}
