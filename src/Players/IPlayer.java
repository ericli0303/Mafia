package Players;

/**
 * A representation of a player.
 */
public interface IPlayer {

  /**
   * Gets the PlayerType of the player.
   * @return the PlayerType
   */
  PlayerType getPlayerType();

  /**
   * Gets the PlayerRole of the player.
   * @return the PlayerRole
   */
  PlayerRole getPlayerRole();

  /**
   * Checks to see if the person is still alive.
   * @return true if alive, false otherwise
   */
  boolean isAlive();

  /**
   * Protects the Player from getting killed at night.
   */
  void protectPlayer();

  /**
   * Gets rid of the protection for that Player at night.
   */
  void unprotectPlayer();

  /**
   * Kills the Player, marking him as no longer alive.
   */
  void killPlayer();

  /**
   * Selects another Player for a specific action to happen to them
   * @param p2 The other player that is receiving the action
   */
  void selectForAction(IPlayer p2);

  /**
   * Checks to see if a player is protected for the night.
   * @return true if the player is protected, false otherwise.
   */
  boolean isProtected();

  /**
   * Checks to see if this player can perform an action at night.
   * @return true if player can perform, false otherwise.
   */
  boolean hasAction();

  /**
   * Performs the action once the phase changes from NightTime to DayTime.
   * @throws IllegalCallerException if it is called on a Player that has no action.
   */
  void executeAction();

  /**
   * Resets the data for the player.
   */
  void reset();

  /**
   * Votes to lynch the selected player.
   * @param p2 the selected player
   */
  void lynch(IPlayer p2);


  /**
   * Gets the selected vote for the otherPlayer.
   * @return the IPlayer that was selected for otherPlayer
   */
  IPlayer getOtherPlayer();

}
