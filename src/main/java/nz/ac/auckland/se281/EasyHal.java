package nz.ac.auckland.se281;

// Object for difficulty EASY
public class EasyHal implements Hal9000 {

  public EasyHal() {}

  @Override
  public int play() {
    StrategyMaster hal = new StrategyMaster(new RandomStrat());
    return hal.think();
  }
}