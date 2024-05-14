package nz.ac.auckland.se281;

import javax.swing.plaf.metal.MetalProgressBarUI;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;
import java.util.ArrayList;

/** This class represents the Game is the main entry point. */
public class Game {

  int roundNumber = 0;
  int sum;
  String winner;
  ArrayList<Integer> playerHistory = new ArrayList<Integer>();

  String playerName;
  Difficulty difficulty;
  Choice choice;
  Hal9000 hal;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    playerName = options[0];
    this.difficulty = difficulty;
    this.choice = choice;
    roundNumber = 0;
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.hal = HalFactory.createHal(difficulty, choice);
  }

  public void play() {
    int playerChoice;
    int halChoice;

    roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    
    // Deal with player input
    while (true) {
      String input = Utils.scanner.nextLine();

      // Checks input is integer
      if (!Utils.isInteger(input)) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      } else {
        playerChoice = Integer.parseInt(input);
      }

      // Checks input is between 0 and 5
      if (playerChoice < 0 | (playerChoice > 5)) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      
      MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);
      playerHistory.add(playerChoice);
      break;
    }

    // Deal with AI
    halChoice = hal.play();
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(halChoice));

    // Deal with outcome of round
    sum = playerChoice + halChoice;
    switch (choice) {
      case ODD:
        if (Utils.isOdd(sum)) {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
        } else {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
        }
        
      case EVEN:
        if (Utils.isEven(sum)) {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
        } else {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
        }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
