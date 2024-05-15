package nz.ac.auckland.se281;

public interface Strategy {

  /**
   * Use the built in algorithm to generate a number of fingers
   * ranging from 0 to 5.
   * 
   * @return the result of the algorithm as an integer
   */
  int makeDecision();
}
