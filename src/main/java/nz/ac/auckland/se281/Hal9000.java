package nz.ac.auckland.se281;

/**
 * An interface that defines the methods that a HAL9000 needs, in order
 * to be of type Hal9000.
 * 
 * @author Henry Ly
 */
public interface Hal9000 {

  /** 
   * Make AI pick a number of fingers and return it for the game to decide what to do
   * next.
   *
   * @return the result of the think method of StrategyMaster brain.
   */
  public int play();

  /**
   * Add a move a player just made to HAL-9000's memory so that if required HAL-9000 can
   * use it to determine its next move.
   * 
   * @param playerChoice whether the goal of the player is to get an EVEN or ODD number
   */
  public void addPlayerMove(int playerChoice);
}
