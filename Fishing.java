public class Fishing {
  private int totalFish;
  private int totalGold;
  public void catchFish(int caught) {
    totalFish += caught;
    System.out.println("You have caught " + caught + " fish.");
  }
  // public void fledAway(int fled) {
  //   totalFish -= fled;
  //   System.out.println(fled + " fish have fled away.");
  //}
  public void sellFish(int fish){
    if ((fish <= totalFish) && (fish >= 0)) {
      totalFish -= fish;
      int addGold = fish*100;
      totalGold += addGold;
      System.out.println("You have sold " + fish + " fish and received " + addGold + " gold.");
    } else {
      System.out.println("You don't have enough fish to sell.");
    }
  }
  public int numFish() {
    return totalFish;
  }
  public int getGold() {
    return totalGold;
  }
}
