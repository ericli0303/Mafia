package Players.Mafia;

import Players.APlayer;
import Players.IPlayer;
import Players.PlayerType;

public abstract class AMafia extends APlayer {
  public AMafia() {
    super();
  }

  @Override
  public PlayerType getPlayerType() {
    return PlayerType.MAFIA;
  }

}
