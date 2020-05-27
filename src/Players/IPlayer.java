package Players;

/**
 * A representation of a player
 */
public interface IPlayer {

  PlayerType getPlayerType();

  PlayerRole getPlayerRole();

  boolean isAlive();

  void protectPlayer();

  void unprotectPlayer();

  void killPlayer();

  void doAction(IPlayer p2);

  String seeInvestigated();
}
