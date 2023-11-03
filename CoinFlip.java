import java.util.Scanner;
public class Coinflip {
  private int max = 1;
  private int min = 0;
  private int coinSide = (int)(Math.random() * (max - min + 1)) + min;
  private int cfBet;
  private static int winStreak;
  public Coinflip(String one) {
    headsOrTails();
    winOrLose();
  }
  public Coinflip(int winStreak) {
    headsOrTails();
    winOrLose();
    winStreak(winStreak);
  }
  public String toString() {
    String betOfSide = "";
    String sideOfCoin = "";
    if (cfBet == 0) betOfSide = "heads";
    if (cfBet == 1) betOfSide = "tails";
    if (coinSide == 0) sideOfCoin = "heads";
    if (coinSide == 1) sideOfCoin = "tails";
    return "You chose " + betOfSide + ". The coin landed on " + sideOfCoin + ". You have a win streak of " + winStreak + ".";
  }
  public void headsOrTails() {
    System.out.println("\nHeads or tails?");
    Scanner scanner = new Scanner(System.in);
    String hOrT = scanner.nextLine();
    if (hOrT.equalsIgnoreCase("heads") || hOrT.equalsIgnoreCase("h")) cfBet = 0;
    else if (hOrT.equalsIgnoreCase("tails") || hOrT.equalsIgnoreCase("t")) cfBet = 1;
    else {
      System.out.println("\nInvalid response. Please try again.");
      headsOrTails();
    }
  }
  public boolean winOrLose() {
    if (cfBet == coinSide) return true;
    else return false;
  }
  public void winStreak(int streak) {
    if (winOrLose() == true) {
      winStreak++;
      System.out.println("You won! Your win streak is now " + winStreak);
    } else {
      winStreak = 0;
      System.out.println("You lost! Your win streak is now " + winStreak);
    }
  }
  public static int getWinStreak() {
    return winStreak;
  }
}
