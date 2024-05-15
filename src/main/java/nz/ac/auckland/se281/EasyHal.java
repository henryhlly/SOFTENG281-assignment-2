package nz.ac.auckland.se281;

import java.util.ArrayList;

// Object for difficulty EASY
public class EasyHal implements Hal9000 {

  private ArrayList<Integer> playerHistory = new ArrayList<Integer>();

  @Override
  public int play() {
    StrategyMaster brain = new StrategyMaster(new RandomStrat());
    return brain.think();
  }

  @Override
  public void addPlayerMove(int playerChoice) {
    playerHistory.add(playerChoice);
  }
}