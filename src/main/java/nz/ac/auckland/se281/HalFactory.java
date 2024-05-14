package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.Main.Choice;

// Factory for creating Hal's of different difficulty
public class HalFactory {

  public static Hal9000 createHal(Difficulty difficulty, Choice choice) {
    switch (difficulty) {
      case EASY: 
        return new EasyHal();

      case MEDIUM:
        return new MediumHal(choice);

      case HARD:
        return new HardHal(choice);
    }
    return null;
  }
}
