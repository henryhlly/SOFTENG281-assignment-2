package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

// Factory for creating Hal's of different difficulty
public class HalFactory {
  public static Hal9000 createHal(Difficulty difficulty) {
    switch (difficulty) {
      case EASY: 
        return new EasyHal();

      case MEDIUM:
        return new MediumHal();

      case HARD:
        return null;
    }
    return null;
  }
}
