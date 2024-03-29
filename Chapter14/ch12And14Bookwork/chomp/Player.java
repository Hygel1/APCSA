package Chapter14.Ch12And14Bookwork.chomp;

/**
 * A player in a game
 */

public interface Player
{
  /**
   * Returns a prompt to be displayed before
   * the next move of this player
   */
  String getPrompt();
  String getName();

  /**
   * Returns a message to be displayed when
   * this player has won
   */
  String getWinMessage();

  /**
   * Initiates this player's next move
   */
  void makeMove();
}

