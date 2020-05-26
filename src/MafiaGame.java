import java.util.List;

/**
 * Creates a model of a Mafia Game using the IMafiaGame interface
 */
public class MafiaGame implements IMafiaGame{
  @Override
  public List getDeck() {
    return null;
  }

  @Override
  public void startGame(List players, int numPlayers) {

  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public void changePhase() {

  }

  @Override
  public Object isNominated() {
    return null;
  }

  @Override
  public List getPlayers() {
    return null;
  }

  @Override
  public List getMafia() {
    return null;
  }

  @Override
  public List getTown() {
    return null;
  }

  @Override
  public void doAction(PlayerType pile1, int player1, PlayerType pile2, int player2) {

  }

  @Override
  public void doNomination(PlayerType pile1, int player1, PlayerType pile2, int player2) {

  }

  @Override
  public String getGameState() {
    return null;
  }

  @Override
  public Object getPlayer(PlayerType pile, int player) {
    return null;
  }
}
