package Players.Town;

import Players.APlayer;
import Players.PlayerType;

public abstract class ATown extends APlayer {
  public ATown() {
    super();
  }

  @Override
  public PlayerType getPlayerType() {
    return PlayerType.TOWN;
  }
}
