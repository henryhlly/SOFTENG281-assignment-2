package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

// Object for difficulty MEDIUM
public class MediumHal implements Hal9000 {

  public MediumHal() {}


  @Override
  public int play() {
    int numberOfEven = 0;
    int numberOfOdd = 0;
    
    // Calculate the number of even
    for (int i : playerHistory) {
      if (Utils.isEven(i)) {
        numberOfEven++;
      }
    }
    numberOfOdd = playerHistory.size() - numberOfEven;

    if ((playerHistory.size() > 3) & (numberOfEven != numberOfOdd)) {
      
      if (numberOfEven > numberOfOdd) {
        // When Hal thinks player will choose EVEN

      } else {
        // When Hal thinks player will choose ODD

      }

    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}