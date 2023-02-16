package Chapter14.Ch12And14Bookwork.chomp;

/**
 * A strategy in a game
 */

public interface Strategy
{
  Location findBestMove(ChompGame game);
  Location findRandomMove(ChompGame game);
}
