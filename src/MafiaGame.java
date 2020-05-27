import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import Players.IPlayer;
import Players.Mafia.MafiaPlayer;
import Players.PlayerType;
import Players.Town.DetectivePlayer;
import Players.Town.NursePlayer;
import Players.Town.TownPlayer;

/**
 * Creates a model of a Mafia Game using the IMafiaGame interface
 */
public class MafiaGame implements IMafiaGame {
  private HashMap<Integer, Integer> lynchVotes;
  private List<IPlayer> players;
  private Phase currentPhase;

  public MafiaGame() {
    lynchVotes = new HashMap<>();
    players = new ArrayList<>();
    currentPhase = Phase.DAYTIME;
  }

  @Override
  public List getDeck(int numPlayers) {
    if (numPlayers < 4) {
      throw new IllegalArgumentException("Too few players!");
    }
    int numMafia = (int) (numPlayers * .3);
    int numTown = numPlayers - numMafia - 2;
    List<IPlayer> players = new ArrayList<>();
    for (int i = 0; i < numMafia; i++) {
      players.add(new MafiaPlayer());
    }
    for (int i = 0; i < numTown; i++) {
      players.add(new TownPlayer());
    }
    players.add(new NursePlayer());
    players.add(new DetectivePlayer());
    return players;
  }

  @Override
  public HashMap<Integer, Integer> getLynchVotes() {
    return null;
  }

  @Override
  public void startGame(List<IPlayer> players, int numPlayers) {
    Collections.shuffle(players);
    List<IPlayer> tempPlayers = new ArrayList<>();
    for (int i = 0; i < numPlayers; i++) {
      tempPlayers.add(players.get(i));
    }
    if (isValid(tempPlayers)) {
      for (int i = 0; i < tempPlayers.size(); i++) {
        this.players.add(tempPlayers.get(i));
      }
    } else {
      throw new IllegalArgumentException("A valid deck cannot be guaranteed with your input retard");
    }
  }

  /**
   * Return whether or not the given list of players is valid.
   *
   * @param players the given list of players
   * @return true if town players outnumber the mafia, false otherwise
   */
  private boolean isValid(List<IPlayer> players) {
    int mafia = 0;
    int town = 0;
    for (IPlayer p : players) {
      if (p.getPlayerType() == PlayerType.MAFIA) {
        mafia++;
      } else if (p.getPlayerType() == PlayerType.TOWN) {
        town++;
      }
    }
    return town > mafia;
  }

  @Override
  public boolean isGameOver() {
    // if more/equal number of mafia alive to town alive
    if (getMafia().size() >= getTown().size()) {
      return true;
    } else if (getMafia().isEmpty()) {
      return true;
    }
    return false;
  }

  @Override
  public void changePhase() {
    if (currentPhase == Phase.DAYTIME) {
      currentPhase = Phase.NIGHTTIME;
    } else if (currentPhase == Phase.NIGHTTIME) {
      currentPhase = Phase.DAYTIME;
    } else if (currentPhase == Phase.LYNCHING) {
      currentPhase = Phase.NIGHTTIME;
    } else {
      throw new IllegalArgumentException("Current phase cannot be null!");
    }
  }

  @Override
  public IPlayer isNominated() {
    return null;
  }

  @Override
  public List getPlayers() {
    List<IPlayer> living = new ArrayList<>();
    for (IPlayer player : players) {
      if (player.isAlive()) {
        living.add(player);
      }
    }
    return living;
  }

  @Override
  public List getMafia() {
    List<IPlayer> mafia = new ArrayList<>();
    for (IPlayer player : players) {
      if (player.getPlayerType() == PlayerType.MAFIA && player.isAlive()) {
        mafia.add(player);
      }
    }
    return mafia;
  }

  @Override
  public List getTown() {
    List<IPlayer> town = new ArrayList<>();
    for (IPlayer player : players) {
      if (player.getPlayerType() == PlayerType.TOWN && player.isAlive()) {
        town.add(player);
      }
    }
    return town;
  }

  @Override
  public void doAction(int player1, int player2) {
    IPlayer p1 = getPlayer(player1);
    IPlayer p2 = getPlayer(player2);
    p1.doAction(p2);
  }

  @Override
  public void doNomination(int player1, int player2) {

  }

  @Override
  public String getGameState() {
    StringBuilder state = new StringBuilder();
    state.append("Mafia: \n");
    for (int i = 0; i < players.size(); i++) {
      IPlayer p = players.get(i);
      if (p.getPlayerType() == PlayerType.MAFIA) {
        state.append("Player " + i + ": " + (p.isAlive() ? "Alive" : "Dead") + "\n");
      }
    }
    state.append("Town: \n");
    for (int i = 0; i < players.size(); i++) {
      IPlayer p = players.get(i);
      if (p.getPlayerType() == PlayerType.TOWN) {
        state.append("Player " + i + "(" + p.getPlayerRole().toString() + "): " +
                (p.isAlive() ? "Alive" : "Dead") + "\n");
      }
    }
    state.append("Current Phase: " + currentPhase);
    return state.toString();
  }

  @Override
  public IPlayer getPlayer(int player) {
    return players.get(player);
  }
}
