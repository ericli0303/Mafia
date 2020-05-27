package Players.Mafia;

import Players.IPlayer;
import Players.PlayerRole;
import Players.PlayerType;

/**
 * A player sided with the Mafia with the night action to vote to kill one town player.
 */
public class MafiaPlayer extends AMafia {
  public MafiaPlayer() {
    super();
  }
  @Override
  public PlayerRole getPlayerRole() {
    return PlayerRole.MAFIA;
  }

  @Override
  public void doAction(IPlayer p2) {

  }

}
