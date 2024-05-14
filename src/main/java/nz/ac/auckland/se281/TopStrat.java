package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import java.util.ArrayList;


public class TopStrat implements Strategy {
  
  Choice choice;
  int numberOfEven;
  int numberOfOdd;

  public TopStrat(Choice choice, ArrayList<Integer> playerHistory) {
    this.choice = choice;

    // Calculate the number of even and odd
    for (int i : playerHistory) {
      if (Utils.isEven(i)) {
        numberOfEven++;
      }
    }
    numberOfOdd = playerHistory.size() - numberOfEven;
  }

  public int makeDecision() {
    switch (choice) {
      case EVEN:
        if (numberOfEven == numberOfOdd) {
          // When Hal does not know what player will choose
          return Utils.getRandomNumberRange(0, 5);
        } else if (numberOfEven > numberOfOdd) {
          // When Hal thinks player will choose EVEN
          // EVEN + ODD = ODD
          return Utils.getRandomOddNumber();

        } else {
          // When Hal thinks player will choose ODD
          // ODD + EVEN = ODD
          return Utils.getRandomEvenNumber();
        }

      case ODD:
        if (numberOfEven == numberOfOdd) {
          // When Hal does not know what player will choose
          return Utils.getRandomNumberRange(0, 5);
        } else if (numberOfEven > numberOfOdd) {
          // When Hal thinks player will choose EVEN
          // EVEN + EVEN = EVEN
          return Utils.getRandomEvenNumber();

        } else {
          // When Hal thinks player will choose ODD
          // ODD + ODD = EVEN
          return Utils.getRandomOddNumber();
        }
    }
    return -1;
  }

}