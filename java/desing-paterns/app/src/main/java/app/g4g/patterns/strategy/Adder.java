package app.g4g.patterns.strategy;

import java.util.Collection;

public interface Adder<T> {
  
  T add (Collection<T> argList);
}
