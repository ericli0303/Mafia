package Players.Town;

import Players.IPlayer;
import Players.PlayerRole;
import Players.PlayerType;

/**
 * A player sided with the town with the night action to investigate one player.
 */
public class DetectivePlayer extends ATown {
  private PlayerType investigation;
  public DetectivePlayer() {
    super();
  }
  @Override
  public PlayerRole getPlayerRole() {
    return PlayerRole.DETECTIVE;
  }

  @Override
  public void doAction(IPlayer p2) {
    investigation = p2.getPlayerType();
  }

  @Override
  public String seeInvestigated() {
    return investigation.toString();
  }
}
