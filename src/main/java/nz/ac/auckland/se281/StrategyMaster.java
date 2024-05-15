package nz.ac.auckland.se281;

/**
 * A class that acts as a controller for the Strategy types. Allows
 * other objects to interact with the strategies and use them.
 * 
 * @author Henry Ly
 */
public class StrategyMaster {
  private Strategy strat;
  
  // Constructor to set default first strategy
  public StrategyMaster(Strategy strat) {
    this.strat = strat;
  }

  // Setter method to set different strategies
  public void setStrategy(Strategy strat) {
    this.strat = strat;
  }

  // Getter method to get current strategy
  public Strategy getStrategy() {
    return strat;
  }

  /**
   * Method to actually use the strategy and get the number of
   * fingers.
   * 
   * @return the result of the strategy's algroithm
   */
  public int think() {
    return strat.makeDecision();
  }
}
