package nz.ac.auckland.se281;

import java.util.ArrayList;

// Interface for defining Hal's
public interface Hal9000 {
  public int play();

  public void addPlayerMove(int playerChoice);

  public ArrayList<Integer> getPlayerHistory();
}
