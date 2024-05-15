package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

/**
 * A class that represents a Hal9000 object that is of HARD difficulty.
 * 
 * @author Henry Ly
 */
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

  /** 
   * Make AI pick a number of fingers based off of the HARD difficulty
   * and return it for the game to decide what to do next.
   *
   * @return the result of the think method of StrategyMaster brain.
  */
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

  /**
   * Add a move a player just made to HAL-9000's memory so that if required HAL-9000 can
   * use it to determine its next move.
   * 
   * @param playerChoice whether the goal of the player is to get an EVEN or ODD number
   */
  @Override
  public void addPlayerMove(int playerChoice) {
    playerHistory.add(playerChoice);
  }
}