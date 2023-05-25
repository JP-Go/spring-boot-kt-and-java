package app.g4g.patterns.strategy;

import java.util.Collection;

public class ImperativeNumberAdder implements Adder<Double> {

  @Override
  public Double add(Collection<Double> argList) {
    Double result = 0d;
    for (Double n : argList) {
      result += n;
    }
    return result;
  }

}
