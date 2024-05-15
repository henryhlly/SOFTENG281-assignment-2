package nz.ac.auckland.se281;

/**
 * An interface that defines the methods that a Strategy needs, in order
 * to be of type Strategy.
 * 
 * @author Henry Ly
 */
public interface Strategy {

  /**
   * Use the built in algorithm to generate a number of fingers
   * ranging from 0 to 5.
   * 
   * @return the result of the algorithm as an integer
   */
  int makeDecision();
}
