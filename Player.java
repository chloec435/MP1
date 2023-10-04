public class Player {
  private String playerName;
  // private int playerGold;
  // private int playerFish;
  public Player(String name) {
    playerName = name;
  }
  public void setName(String name) {
    playerName = name;
  }
  public String getName() {
    return playerName;
  }
//   public void addGold(int gold) {
//     playerGold += gold;
//   }
//   public int checkGold() {
//     return playerGold;
//   }
//   public void addFish(int fish) {
//     playerFish += fish;
//   }
//   public int checkFish() {
//     return playerFish;
//   }
}
