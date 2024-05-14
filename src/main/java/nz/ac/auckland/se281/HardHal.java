package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

// Object for difficulty MEDIUM
public class HardHal implements Hal9000 {

  private ArrayList<Integer> playerHistory = new ArrayList<Integer>();
  private StrategyMaster brain;
  private String prevWinner;
  private Strategy topStrat;
  private Strategy randomStrat;

  public HardHal(Choice choice, String winner) {
    prevWinner = winner;
    topStrat = new TopStrat(choice, playerHistory);
    randomStrat = new RandomStrat();
    brain = new StrategyMaster(randomStrat);
  }

  @Override
  public int play() {
    if (playerHistory.size() > 3) {
      if (prevWinner == "HAL-9000") {}
      else {
        if (brain.getStrategy() instanceof RandomStrat) {
          brain.setStrategy(topStrat);
        } else if (brain.getStrategy() instanceof TopStrat) {
          brain.setStrategy(randomStrat);
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

  @Override
  public ArrayList<Integer> getPlayerHistory() {
    return playerHistory;
  }
}