package nz.ac.auckland.se281;

import java.util.ArrayList;

/**
 * A class that represents a Hal9000 object that is of EASY difficulty.
 *
 * @author Henry Ly
 */
public class EasyHal implements Hal9000 {

  private ArrayList<Integer> playerHistory = new ArrayList<Integer>();

  /** 
   * Make AI pick a number of fingers based off of the EASY difficulty
   * and return it for the game to decide what to do next.
   *
   * @return the result of the think method of StrategyMaster brain.
  */
  @Override
  public int play() {
    StrategyMaster brain = new StrategyMaster(new RandomStrat());
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