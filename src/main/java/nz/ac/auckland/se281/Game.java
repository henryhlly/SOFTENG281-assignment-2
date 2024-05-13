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
    String input = "";
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    
    while (!Utils.isInteger(input)) {
      input = Utils.scanner.nextLine();
    }
  }

  public void endGame() {}

  public void showStats() {}
}
