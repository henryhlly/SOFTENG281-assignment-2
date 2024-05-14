package nz.ac.auckland.se281;

// Object for difficulty EASY
public class EasyHal implements Hal9000 {

  private Strategy strat;

  public EasyHal() {
    strat = new RandomStrat();
  }

  @Override
  public int play() {
    return strat.makeDecision();
  }
}