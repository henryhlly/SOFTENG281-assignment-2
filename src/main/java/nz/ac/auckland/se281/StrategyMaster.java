package nz.ac.auckland.se281;

public class StrategyMaster {
  private Strategy strat;
  
  public StrategyMaster(Strategy strat) {
    this.strat = strat;
  }

  public void setPayment(Strategy strat) {
    this.strat = strat;
  }

  public int think() {
    return strat.makeDecision();
  }
}
