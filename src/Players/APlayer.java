package Players;

public abstract class APlayer implements IPlayer {

  protected boolean isAlive;
  protected boolean isProtected;

  public APlayer() {
    isAlive = true;
    isProtected = false;
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
  public String seeInvestigated() {
    return "";
  }
}
