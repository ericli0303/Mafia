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

  /**
   * Gets the PlayerType of the Person investigated
   * @return the PlayerType in the form of a String
   */
  public String seeInvestigated() {
    return investigation.toString();
  }

  @Override
  public boolean hasAction() {
    return true;
  }

  @Override
  public void executeAction() {
    investigation = otherPlayer.getPlayerType();
  }
}
