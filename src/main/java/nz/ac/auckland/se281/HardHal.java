package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

// Object for difficulty HARD
public class HardHal implements Hal9000 {

  private ArrayList<Integer> playerHistory = new ArrayList<Integer>();
  private StrategyMaster brain;
  private String prevWinner;
  private Choice choice;

  // Constructor for setting choice and winner
  public HardHal(Choice choice, String winner) {
    prevWinner = winner;
    this.choice = choice;
    brain = new StrategyMaster(new RandomStrat());
  }

  @Override
  public int play() {
    // Deal with strategy switching for Hard HAL
    if (playerHistory.size() > 3) {
      if (prevWinner != "HAL-9000") {
        if (brain.getStrategy() instanceof RandomStrat) {
          brain.setStrategy(new TopStrat(choice, playerHistory));
        } else if (brain.getStrategy() instanceof TopStrat) {
          brain.setStrategy(new RandomStrat());
        } else {
          System.out.println("Error; No such Strat");
        }
      }
    }
    return brain.think();
  }

  @Override
  public void addPlayerMove(int playerChoice) {
    playerHistory.add(playerChoice);
  }
}