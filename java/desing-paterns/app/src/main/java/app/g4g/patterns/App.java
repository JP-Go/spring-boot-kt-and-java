package app.g4g.patterns;

import java.util.Collection;
import java.util.List;
import app.g4g.patterns.strategy.DoubleAdder;
import app.g4g.patterns.strategy.FunctionalNumberAdder;
import app.g4g.patterns.strategy.ImperativeNumberAdder;

public class App {

  private static void print(String arg) {
    System.out.println(arg);
  }

  public static void main(String[] args) {
    Collection<Double> listOfDoubles = List.of(1d, 2d, 3d, 4d, 5d);

    DoubleAdder adder = new DoubleAdder();
    adder.setAdder(new ImperativeNumberAdder());
    print(adder.add(listOfDoubles).toString());
    adder.setAdder(new FunctionalNumberAdder());
    print(adder.add(listOfDoubles).toString());
  }
}
