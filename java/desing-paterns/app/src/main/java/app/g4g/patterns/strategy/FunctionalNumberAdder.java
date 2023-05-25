package app.g4g.patterns.strategy;

import java.util.Collection;
import java.util.stream.Collectors;

public class FunctionalNumberAdder implements Adder<Double> {

  @Override
  public Double add(Collection<Double> argList) {

    return argList.stream()
        .collect(Collectors.summingDouble(Double::doubleValue));
  }

}
