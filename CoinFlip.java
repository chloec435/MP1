import java.util.Scanner;
public class CoinFlip {
  private int headsOrTails;
  private int coin;
  public void flip(String HorT) {
    int max = 1;
    int min = 0;
    int range = max - min + 1;
    int bet = (int)(Math.random() * range) + min;
    coin = bet;
    if (HorT.equals("heads") || HorT.equals("h")) {
      headsOrTails = 0;
    } else if (HorT.equals("tails") || HorT.equals("t")) {
      headsOrTails = 1;
    }
    if (headsOrTails = bet) {
      System.out.println("Congrats! You have guessed right!");
    } else {
      System.out.println("Sorry, better luck next time!");
    }
  }
  public int headsOrTails() {
    return headsOrTails;
  }
  public int getCoin() {
    return ht;
  }
}
