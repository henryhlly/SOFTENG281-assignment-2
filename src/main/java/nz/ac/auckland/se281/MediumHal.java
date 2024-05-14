package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

// Object for difficulty MEDIUM
public class MediumHal implements Hal9000 {

  private ArrayList<Integer> playerHistory = new ArrayList<Integer>();
  private Choice choice;

  public MediumHal(Choice choice) {
    this.choice = choice;
  }

  @Override
  public int play() {
    StrategyMaster brain = new StrategyMaster(new RandomStrat());
    if (playerHistory.size() > 3) {
      brain.setStrategy(new TopStrat(choice, playerHistory));
    }

    return brain.think();
  }

  @Override
  public void addPlayerMove(int playerChoice) {
    playerHistory.add(playerChoice);
  }

  @Override
  public ArrayList<Integer> getPlayerHistory() {
    return playerHistory;
  }
}