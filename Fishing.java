public class Fishing {
  private int totalFish;
  private int totalGold;
  public void catchFish(int caught) {
    if (totalFish <= Integer.MAX_VALUE) {
      totalFish += caught;
      System.out.println("You have caught " + caught + " fish.");
    } else {
      System.out.println("No more fish can be added to your inventory. You have reached the maximum fish limit of " + Integer.MAX_VALUE + ".");
    }
  }
  
  public void sellFish(int fish){
    if ((fish <= totalFish) && (fish >= 0)) {
      totalFish -= fish;
      Integer addGold = new Integer(fish*100);
      if (totalGold <= Integer.MAX_VALUE) {
        totalGold += addGold.intValue();
        System.out.println("\nYou have sold " + fish + " fish and received " + addGold.intValue() + " gold.");
      } else {
        System.out.println("\nNo more gold can be added to your balance. You have reached the maximum gold limit of " + Integer.MAX_VALUE + ".");
      }
    } else {
      System.out.println("\nYou don't have enough fish to sell. You currently have a total of " + totalFish + " fish.");
    }
  }
  
  public void addGold(boolean winOrLose, int bet) {
    if (winOrLose == true) {
      if (totalGold <= Integer.MAX_VALUE) {
        totalGold += bet;
        System.out.println("Congrats! You have guessed right! \nYou have received " + bet*2 + " gold.");
      } else {
        System.out.println("\nNo more gold can be added to your balance. You have reached the maximum gold limit of " + Integer.MAX_VALUE + ".");
      }
    } else if (winOrLose == false) {
      totalGold -= bet;
      System.out.println("Sorry, better luck next time! \nYou have lost " + bet + " gold.");
    }
  }
  
  public void addGold(boolean winOrLose, int bet, int winStreak) {
    if (winOrLose == true) {
      if (totalGold <= Integer.MAX_VALUE) {
        totalGold += bet*winStreak*1.5;
        System.out.println("You have received " + (bet*winStreak*1.5) + " gold.");
      } else {
        System.out.println("\nNo more gold can be added to your balance. You have reached the maximum gold limit of " + Integer.MAX_VALUE + ".");
      }
    } else if (winOrLose == false) {
      totalGold -= bet;
      System.out.println("You have lost " + bet + " gold.");
    }
  }
  
  public void addGold(int bet) {
    if (totalGold <= Integer.MAX_VALUE) {
      totalGold += bet;
      System.out.println("You have received " + bet*2 + " gold.");
    } else {
      System.out.println("\nNo more gold can be added to your balance. You have reached the maximum gold limit of " + Integer.MAX_VALUE + ".");
    }
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
