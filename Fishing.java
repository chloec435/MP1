public class Fishing {
  private int totalFish;
  private int totalGold;
  public void catchFish(int caught) {
    totalFish += caught;
    System.out.println("You have caught " + caught + " fish.");
  }
  public void sellFish(int fish){
    if ((fish <= totalFish) && (fish >= 0)) {
      totalFish -= fish;
      Integer addGold = new Integer(fish*100);
      totalGold += addGold.intValue();
      System.out.println("You have sold " + fish + " fish and received " + addGold.intValue() + " gold.");
    } else {
      System.out.println("You don't have enough fish to sell. You currently have a total of " + totalFish + " fish.");
    }
  }
  // public void addGold(boolean winOrLose, int bet) {
  //   if (winOrLose == true) {
  //     totalGold += bet;
  //     System.out.println("Congrats! You have guessed right! \nYou have received " + bet*2 + " gold.");
  //   } else if (winOrLose == false) {
  //     totalGold -= bet;
  //     System.out.println("Sorry, better luck next time! \nYou have lost " + bet + " gold.");
  //   }
  // }
  public void addGold(boolean winOrLose, int bet, int winStreak) {
    if (winOrLose == true) {
      totalGold += bet*2*winStreak*1.5-bet;
      System.out.println("You have received " + (bet*2*winStreak*1.5-bet) + " gold.");
    } else if (winOrLose == false) {
      totalGold -= bet;
      System.out.println("You have lost " + bet + " gold.");
    }
  }
  public void addGold(int bet) {
    totalGold += bet;
    System.out.println("You have received " + bet*2 + " gold.");
  }
  public void removeGold(int bet) {
    totalGold -= bet;
    System.out.println("Sorry, better luck next time! \nYou have lost " + bet + " gold.");
  }
  public int numFish() {
    return totalFish;
  }
  public int getGold() {
    return totalGold;
  }
}
