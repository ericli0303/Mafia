package Players;

/**
 * Type for the three types of players in a game of Mafia. <br> Mafia: This player type wins when
 * they comprise of the majority of the Players in the game.<br> Town: This player type wins when
 * there are no more Mafia left in the game. <br> Other: This is a WIP.
 */
public enum PlayerType {
  MAFIA("mafia"), TOWN("town"), OTHER("other");

  private final String disp;

  PlayerType(String disp) {this.disp = disp;}

  @Override
  public String toString() {
    return disp;
  }
}
