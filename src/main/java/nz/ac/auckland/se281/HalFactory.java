package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

// Factory for creating Hal's of different difficulty
public class HalFactory {

  /**
   * Creates a HAL-9000 object of chosen difficulty
   * 
   * @param difficulty the chosen difficulty
   * @param choice whether the goal of the player is to get an EVEN or ODD number
   * @param winner the winner of the last round
   * @return the newly made HAL-9000 object
   */
  public static Hal9000 createHal(Difficulty difficulty, Choice choice, String winner) {
    // Create corresponding HAL objects
    switch (difficulty) {
      case EASY:
        return new EasyHal();

      case MEDIUM:
        return new MediumHal(choice);

      case HARD:
        return new HardHal(choice, winner);
    }
    return null;
  }
}
