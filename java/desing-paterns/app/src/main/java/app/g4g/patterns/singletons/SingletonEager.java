package app.g4g.patterns.singletons;

/**
 *
 * SingletonLazy
 *
 * @author JP
 *
 */

public class SingletonEager {

  private static SingletonEager instance = new SingletonEager();

  private SingletonEager() {
    super();
  }

  public static SingletonEager getInstance() {
    return SingletonEager.instance;
  }

}
