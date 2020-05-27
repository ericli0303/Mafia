package Players;

/**
 * Possible roles of players in a game of Mafia. <br> Mafia: This role wins when they comprise of
 * the majority of the Players in the game.<br> Town: This role wins when there are no more Mafia
 * left in the game. <br> Nurse: This role chooses a player to save during the night, and is sided
 * with the town. <br> Detective: This role chooses a player to investigate during the night, and is
 * sided with the town.
 */
public enum PlayerRole {
  MAFIA("mafia"), NURSE("nurse"), DETECTIVE("detective"), TOWN("town");

  private final String disp;

  PlayerRole(String disp) {this.disp = disp;}

  @Override
  public String toString() {
    return disp;
  }
}
