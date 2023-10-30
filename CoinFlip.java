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
  public void headsOrTails() {
    System.out.println("Heads or tails?");
    Scanner scanner = new Scanner(System.in);
    String hOrT = scanner.nextLine();
    if (hOrT.equalsIgnoreCase("heads") || hOrT.equalsIgnoreCase("h")) cfBet = 0;
    else if (hOrT.equalsIgnoreCase("tails") || hOrT.equalsIgnoreCase("t")) cfBet = 1;
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
