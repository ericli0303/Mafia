package Players.Town;

import Players.IPlayer;
import Players.PlayerRole;
import Players.PlayerType;

/**
 * A player sided with the town with the night action to save one player.
 */
public class NursePlayer extends ATown {
  public NursePlayer() {
    super();
  }
  @Override
  public PlayerRole getPlayerRole() {
    return PlayerRole.NURSE;
  }

  @Override
  public void doAction(IPlayer p2) {
    p2.protectPlayer();
  }
}
