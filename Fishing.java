public class Fishing {
  private int totalFish;
  private int gold;
  // public Fishing(){
  //   totalFish = 0;
  //   gold = 0;
  //   catchFish();
  //   fledAway();
  //   sellFish();
  // }
  public void catchFish(int caught) {
    totalFish += caught;
    System.out.println("You have caught " + caught + "fish.");
  }
  public void fledAway(int fled) {
    totalFish -= fled;
    System.out.println(fled + " fish have fled away.");
  }
  public void sellFish(int fish){
    totalFish -= fish;
    gold = fish*5;
    System.out.println("You have sold " + fish + " fish and received " + gold + ".");
  }
  public int numFish() {
    return totalFish;
  }
  public int getGold() {
    return gold;
  }
}
