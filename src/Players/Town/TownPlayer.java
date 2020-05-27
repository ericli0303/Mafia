package Players.Town;

import Players.IPlayer;
import Players.PlayerRole;
import Players.Town.ATown;

/**
 * A player sided with the town with no night actions.
 */
public class TownPlayer extends ATown {
  public TownPlayer() {
    super();
  }
  @Override
  public PlayerRole getPlayerRole() {
    return PlayerRole.TOWN;
  }

  @Override
  public void doAction(IPlayer p2) {
    throw new IllegalArgumentException("Town players do not have night actions!");
  }
}
