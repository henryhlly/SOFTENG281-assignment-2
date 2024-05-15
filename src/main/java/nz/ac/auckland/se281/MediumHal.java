package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

// Object for difficulty MEDIUM
public class MediumHal implements Hal9000 {

  private ArrayList<Integer> playerHistory = new ArrayList<Integer>();
  private Choice choice;
  private StrategyMaster brain;

  // Constructor for setting choice
  public MediumHal(Choice choice) {
    this.choice = choice;
    brain = new StrategyMaster(new RandomStrat());
  }

  /** 
   * Make AI pick a number of fingers based off of the MEDIUM difficulty
   * and return it for the game to decide what to do next.
   *
   * @return the result of the think method of StrategyMaster brain.
  */
  @Override
  public int play() {
    if (playerHistory.size() > 3) {
      brain.setStrategy(new TopStrat(choice, playerHistory));
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