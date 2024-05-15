package nz.ac.auckland.se281;

/**
 * A class that represents a Strategy object that contains the
 * algorithm for the Random Strategy as defined in the assignment.
 * 
 * @author Henry Ly
 */
public class RandomStrat implements Strategy {

  /**
   * Use the built in algorithm to generate a number of fingers
   * ranging from 0 to 5. Since it is RandomStrat then the result
   * is randomly decided
   * 
   * @return a randomly selected number ranging from 0 to 5
   */
  public int makeDecision() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
