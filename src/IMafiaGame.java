import java.util.List;

/**
 * This is the interface of the Mafia Game. It is parameterized over the player type. This takes
 * care of the basic functions of what the Mafia game should perform.
 *
 * @param <IPlayer>> Player
 */
public interface IMafiaGame<IPlayer> {


  /**
   * Return a valid deck of cards for a game of Mafia. An invalid deck is defined as a deck that has
   * one or more of these flaws: <ul> <li>It has more Mafia than Town</li> <li>It is missing a
   * detective</li></ul>
   *
   * @return the deck of players as a list
   */
  List<IPlayer> getDeck();

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
  void doAction(PlayerType pile1, int player1, PlayerType pile2, int player2);

  /**
   * Where one player nominates another player to be lynched.
   *
   * @param pile1 the PileType of the player doing the nomination
   * @param player1 the index of the player doing the nomination
   * @param pile2 the PileType of the player receiving the nomination
   * @param player2 the index of the player receiving the nomination
   */
  void doNomination(PlayerType pile1, int player1, PlayerType pile2, int player2);

  /**
   * Gets the current game state. Should return a list of the Mafia, Town, and current phase of the game.
   *
   * @return
   */
  String getGameState();

  /**
   * Gets the Player from the corresponding PlayerType pile
   *
   * @param pile the pile the player is in
   * @param player the index the player is at
   * @return the player at corresponding index of the pile.
   */
  IPlayer getPlayer(PlayerType pile, int player);


}
