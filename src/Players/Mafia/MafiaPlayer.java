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
  public void selectForAction(IPlayer p2) {
    if(p2.getPlayerType() == PlayerType.MAFIA ) {
      throw new IllegalArgumentException("Cannot attack Mafia");
    } else {
      otherPlayer = p2;
    }
  }

  @Override
  public boolean hasAction() {
    return true;
  }

  @Override
  public void executeAction() {
    if(!otherPlayer.isProtected()) {
      otherPlayer.killPlayer();
    }
  }
}
