import java.util.InputMismatchException;
import java.util.Scanner;
public class Game {
  private Fishing fishing;
  private Blackjack blackjack = null;
  private Coinflip coinflip = null;
  private int bjBet;
  private Scanner scanner;
  private String command;
  private int sell;
  public Game() {
    fishing = new Fishing();
    scanner = new Scanner(System.in);
    playerInfo();
    command = "start";
    while(!command.equals("end")) {
      System.out.println("Type a command:");
      scanner = new Scanner(System.in);
      command = scanner.nextLine();
      commands(command);
      if (command.equalsIgnoreCase("coinflip") || command.equalsIgnoreCase("cf")) coinFlip();
      if (command.equalsIgnoreCase("blackjack") || command.equalsIgnoreCase("bj")) blackJack();
      if (command.equalsIgnoreCase("end")) break;
    }
  }
  
  public void playerInfo() {
    System.out.println("Enter a user name:");
    Scanner b = new Scanner(System.in);
    String playerName = b.nextLine();
    System.out.println("Hello " + playerName + ". \nType \"catch\" or \"c\" to catch some fish. \nType \"sell\" or \"s\" to sell fish. \nType \"fish\" or \"f\" to check how much fish you have. \nType \"gold\" or \"g\" to view your balance. \nType \"coinflip\" or \"cf\" to bet gold on heads or tails. \nType \"blackjack\" or \"bj\" to play a round of blackjack. \nType \"command\" to view the commands. \nType \"end\" to end this game.");
  }
  
  public void commands(String command) {
    int max = 10;
    int min = 1;
    final int range = max - min + 1;
    if (command.equalsIgnoreCase("catch") || command.equalsIgnoreCase("c")) {
      fishing.catchFish((int)(Math.random() * range) + min);
    } else if (command.equalsIgnoreCase("sell") || command.equalsIgnoreCase("s")) {
      System.out.println("How much fish do you want to sell?");
      boolean success = false;
      while (!success) {
        try {
          Scanner c = new Scanner(System.in);
          sell = c.nextInt();
          fishing.sellFish(sell);
          success = true;
        } catch (Exception inputMismatchException) {
          System.out.println("Please enter an integer.");
        }
      }
    } else if (command.equalsIgnoreCase("fish") || command.equalsIgnoreCase("f")) {
      System.out.println("You have a total of " + fishing.numFish() + " fish.");
    } else if (command.equalsIgnoreCase("gold") || command.equalsIgnoreCase("g")) {
      System.out.println("You have " + fishing.getGold() + " gold.");
    } else if (command.equalsIgnoreCase("coinflip") || command.equalsIgnoreCase("cf")) {
      System.out.println("How much gold do you want to bet?");
    } else if (command.equalsIgnoreCase("blackjack") || command.equalsIgnoreCase("bj")) {
      System.out.println("How much gold would you like to bet?");
    } else if (command.equalsIgnoreCase("end")) {
      System.out.println("The game has ended.");
    } else if (command.equalsIgnoreCase("command") || command.equalsIgnoreCase("commands")) {
        System.out.println("Type \"catch\" or \"c\" to catch some fish. \nType \"sell\" or \"s\" to sell fish. \nType \"fish\" or \"f\" to check how much fish you have. \nType \"gold\" or \"g\" to view your balance. \nType \"coinflip\" or \"cf\" to bet gold on heads or tails. \nType \"blackjack\" or \"bj\" to play a round of blackjack. \nType \"command\" to view the commands. \nType \"end\" to end this game.");
    } else {
      System.out.println("Please try again.");
    }
  }

  public void coinFlip() {
    boolean success = false;
    while (!success) {
      try {
        Scanner e = new Scanner(System.in);
        int gold = e.nextInt();
        if (fishing.getGold() < gold) {
          System.out.println("You do not have enough gold. Type \"catch\" to catch some fish or \"sell\" to sell fish for gold!");
        } else {
          if (Coinflip.getWinStreak() == 0) {
            coinflip = new Coinflip("start");
            fishing.addGold(coinflip.winOrLose(), gold);
            coinflip.winStreak(1);
            askStats(coinflip.toString());
          } else {
            coinflip = new Coinflip(Coinflip.getWinStreak()+1);
            fishing.addGold(coinflip.winOrLose(), gold, Coinflip.getWinStreak());
            askStats(coinflip.toString());
          }
        }
        success = true;
      } catch (Exception inputMismatchException) {
        System.out.println("Please enter an integer.");
      }
    }
  }

  public void blackJack() {
    boolean success = false;
    while (!success) {
      try {
        Scanner g = new Scanner(System.in);
        bjBet = g.nextInt();
        if (fishing.getGold() < bjBet) {
          System.out.println("You do not have enough gold. Type \"catch\" to catch some fish or \"sell\" to sell fish for gold!");
        } else {
        blackjack = new Blackjack();
        if (blackjack.getPlayerWin()) fishing.addGold(bjBet);
        else if (!blackjack.getPlayerWin() && !(blackjack.getPlayerTotal() == blackjack.getDealerTotal())) fishing.removeGold(bjBet);
        }
        askStats(blackjack.toString());
        success = true;
      } catch (Exception inputMismatchException) {
        System.out.println("Please enter an integer.");
      }
    }
  }

  public void askStats(String game) {
    System.out.println("Would you like to see the summary of the game (yes/no)?");
    Scanner h = new Scanner(System.in);
    String summary = h.nextLine();
    if (summary.equalsIgnoreCase("yes") || summary.equalsIgnoreCase("y")) {
      System.out.println(game);
    } else if (summary.equalsIgnoreCase("no") || summary.equalsIgnoreCase("n")){
      System.out.println("Okay.");
    }
  }
}
