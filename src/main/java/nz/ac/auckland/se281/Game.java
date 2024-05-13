package nz.ac.auckland.se281;

import javax.swing.plaf.metal.MetalProgressBarUI;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  int roundNumber = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    roundNumber++;
  }

  public void play() {
    String input;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    
    while (true) {
      input = Utils.scanner.nextLine();
      // Checks input is integer
      if (!Utils.isInteger(input)) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      // Checks input is between 0 and 5
      if (Integer.parseInt(input) < 0 | (Integer.parseInt(input) > 5)) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      
      break;
    }


  }

  public void endGame() {}

  public void showStats() {}
}
