package Players;

public abstract class APlayer implements IPlayer {

  protected boolean isAlive;
  protected boolean isProtected;
  protected IPlayer otherPlayer;

  public APlayer() {
    isAlive = true;
    isProtected = false;
    otherPlayer = null;
  }

  @Override
  public void reset() {
    isProtected = false;
    otherPlayer = null;
  }

  @Override
  public void protectPlayer() {
    isProtected = true;
  }

  @Override
  public void unprotectPlayer() {
    isProtected = false;
  }

  @Override
  public void killPlayer() {
    isAlive = false;
  }

  @Override
  public boolean isAlive() {
    return isAlive;
  }

  @Override
  public boolean isProtected() {
    return isProtected;
  }

  @Override
  public void selectForAction(IPlayer p2) {
    if(p2.isAlive()) {
      otherPlayer = p2;
    } else {
      throw new IllegalArgumentException("Must select a living person");
    }
  }

  @Override
  public void lynch(IPlayer p2) {
    otherPlayer = p2;
  }

  @Override
  public IPlayer getOtherPlayer() {
    return otherPlayer;
  }
}
