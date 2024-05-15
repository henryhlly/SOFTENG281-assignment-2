package nz.ac.auckland.se281;

import javax.swing.plaf.metal.MetalProgressBarUI;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;
import java.util.ArrayList;

/** This class represents the Game is the main entry point. */
public class Game {

  int roundNumber = -1;
  int sum;
  String winner = null;
  int playerWins;
  int halWins;
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
    playerWins = 0;
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.hal = HalFactory.createHal(difficulty, choice, winner);
  }

  public void play() {
    int playerChoice;
    int halChoice;

    if (roundNumber == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

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
      hal.addPlayerMove(playerChoice);
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
          winner = playerName;
          playerWins++;
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", winner);
          break;
        } else {
          winner = "HAL-9000";
          halWins++;
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", winner);
          break;
        }
        
      case EVEN:
        if (Utils.isEven(sum)) {
          winner = playerName;
          playerWins++;
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", winner);
          break;
        } else {
          winner = "HAL-9000";
          halWins++;
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", winner);
          break;
        }
    }
  }

  public void endGame() {
    showStats();
    if (playerWins > halWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playerWins < halWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    roundNumber = -1;
  }

  public void showStats() {
    if (roundNumber == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(playerName, String.valueOf(playerWins), String.valueOf(halWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage("HAL-9000", String.valueOf(halWins), String.valueOf(playerWins));
  }
}
