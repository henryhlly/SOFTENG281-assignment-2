package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

// Object for difficulty MEDIUM
public class MediumHal implements Hal9000 {

  private ArrayList<Integer> playerHistory = new ArrayList<Integer>();
  private TopStrat topStrat;
  StrategyMaster brain;

  public MediumHal(Choice choice) {
    topStrat = new TopStrat(choice, playerHistory);
    brain = new StrategyMaster(new RandomStrat());
  }

  @Override
  public int play() {
    topStrat.updatePlayerHistory(playerHistory);

    if (playerHistory.size() > 3) {
      brain.setStrategy(topStrat);
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