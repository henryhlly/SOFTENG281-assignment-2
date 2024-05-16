package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/**
 * Class that represents the main body of the Even/Odds Game.
 *
 * @author Henry Ly
 */
public class Game {
  private int roundNumber = -1;
  private int sum;
  private String winner = null;
  private int playerWins;
  private int halWins;

  private String playerName;
  private Choice choice;
  private Hal9000 hal;

  /**
   * A method that initialises the properties of the game and determines 
   * how its played. Sets difficulty of AI opponent, Goal of the player
   * and player name.
   *
   * @param difficulty the difficulty level of HAL-9000 object
   * @param choice the type of integer that the player is trying to achieve
   * @param options the player name in an array
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Reset/Replace all required game variables
    this.choice = choice;
    playerName = options[0];
    roundNumber = 0;
    playerWins = 0;
    this.hal = HalFactory.createHal(difficulty, choice, winner);
    MessageCli.WELCOME_PLAYER.printMessage(playerName);    
  }

  /**
   * A method that begins a round of the game where it asks player
   * for their move and then gets the move from the AI and compares.
   */
  public void play() {
    int playerChoice;
    int halChoice;

    // Check that NEW_GAME has been done
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
      // Make HAL remember the player's move.
      hal.addPlayerMove(playerChoice);
      break;
    }

    // Deal with AI
    halChoice = hal.play();
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(halChoice));

    // Calculate the outcome of the round
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

  /**
   * A method that will end the game and show stats/outcome of the
   * ended game.
   */
  public void endGame() {
    showStats();

    // Decide who wins the game
    if (playerWins > halWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playerWins < halWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    // Reset the game
    roundNumber = -1;
  }

  /**
   * A method that will show the stats of the current game.
   */
  public void showStats() {
    // Check that NEW_GAME has been done
    if (roundNumber == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, 
        String.valueOf(playerWins), 
        String.valueOf(halWins)
    );
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", 
        String.valueOf(halWins), 
        String.valueOf(playerWins)
    );
  }
}
