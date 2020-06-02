import java.util.HashMap;
import java.util.List;

import Players.IPlayer;
import Players.Mafia.AMafia;

/**
 * This is the interface of the Mafia Game. It is parameterized over the player type. This takes
 * care of the basic functions of what the Mafia game should perform.
 */
public interface IMafiaGame {

  /**
   * Return a valid deck of cards for a game of Mafia. An invalid deck is defined as a deck that has
   * one or more of these flaws: <ul> <li>It has more Mafia than Town</li> <li>It is missing a
   * detective</li></ul>
   *
   * @return the deck of players as a list
   */
  List<IPlayer> getDeck(int numPlayers);

  // Will probably delete this later.
  /**
   * Return a mapping of each player to the player they have voted to lynch.
   *
   * @return
   */
  IPlayer getLynchVote(List<IPlayer> players);

  /**
   * Begins a new game of Mafia with the given deck of players. This method should first verify that
   * this deck is valid. It should then deal out the deck of players to have the number of town,
   * mafia and others into their respective piles. It should only deal out a numPlayers number of
   * cards before trashing the rest of the deck.
   *
   * @param players    the deck of players to be dealt
   * @param numPlayers the number of players in the game
   * @throws IllegalArgumentException if the deck is invalid
   */
  void startGame(List<IPlayer> players, int numPlayers);

  /**
   * Signals if the game is over or not.
   *
   * @return true if the game is over, false otherwise
   */
  boolean isGameOver();

  /**
   * Changes the phase of the game. There are 3 phases in the game: Daytime, Lynching and
   * Nighttime.It should only change to lynching phase if a player is nominated. Otherwise it goes
   * directly from Daytime to Nighttime.
   */
  void changePhase();


  /**
   * Nominates a player to be lynched.
   *
   * @return a player in the game
   */
  IPlayer isNominated();

  /**
   * Gets a list of the living Players in the Game.
   *
   * @return a list of all the Players
   */
  List<IPlayer> getPlayers();

  /**
   * Gets a list of the living Mafia in the Game.
   *
   * @return a list of the Mafia
   */
  List<IPlayer> getMafia();

  /**
   * Gets a list of the living Town in the Game.
   *
   * @return a list of the Town
   */
  List<IPlayer> getTown();

  /**
   * Has one player perform an action on another player depending on the player's role
   *
   * @param player1 the player giving the action on the corresponding deck
   * @param player2 the player receiving the action on the corresponding deck
   */
  void doAction(int player1, int player2);

  /**
   * Where one player nominates another player to be lynched.
   *
   * @param player1 the index of the player doing the nomination
   * @param player2 the index of the player receiving the nomination
   */
  void doNomination(int player1, int player2);

  /**
   * Gets the current game state. Should return a list of the Mafia, Town, and current phase of the
   * game.
   *
   * @return a String that represents the game state
   */
  String getGameState();

  /**
   * Gets the Player from the corresponding index
   *
   * @param player the index the player is at
   * @return the player at corresponding index of the player list
   */
  IPlayer getPlayer(int player);

  /**
   * Gets the Mafia kill. Will select the majority vote, but if there is no majority, selects a vote
   * at random.
   *
   * @return the Player to kill
   */
  IPlayer getMafiaKill(List<AMafia> mafias);


}
