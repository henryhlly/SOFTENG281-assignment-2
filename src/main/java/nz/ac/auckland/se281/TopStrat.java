package nz.ac.auckland.se281;

public class RandomStrat implements Strategy {
  public int makeDecision() {
    return Utils.getRandomNumberRange(0, 5);
  }
}

public class TopStrat implements Strategy 