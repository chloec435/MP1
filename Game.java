import java.util.Scanner;
public class Game {
  private Fishing fishing;
  private Blackjack blackjack;
  private int cfBet;
  private int bjBet;
  private Scanner scanner;
  private String command;
  public Game() {
    fishing = new Fishing();
    scanner = new Scanner(System.in);
    playerInfo();
    command = "start";
    while(!command.equals("end")) {
      scanner = new Scanner(System.in);
      command = scanner.nextLine();
      commands(command);
      if (command.equalsIgnoreCase("coinflip")) coinFlip();
      if (command.equalsIgnoreCase("blackjack")) blackjack();
      if (command.equalsIgnoreCase("end")) break;
    }
  }
  
  public void playerInfo() {
    System.out.println("Enter a user name:");
    Scanner b = new Scanner(System.in);
    String playerName = b.nextLine();
    System.out.println("Hello " + playerName + ". \nType \"catch\" to catch some fish. \nType \"sell\" to sell fish. \nType \"fish\" to check how much fish you have. \nType \"gold\" to view your balance. \nType \"coinflip\" to bet gold on heads or tails. \nType \"blackjack\" to play a round of blackjack. \nType \"command\" to view the commands. \nType \"end\" to end this game.");
  }
  
  public void commands(String command) {
    int max = 100;
    int min = 10;
    int range = max - min + 1;
    if (command.equalsIgnoreCase("catch")) {
      fishing.catchFish((int)(Math.random() * range) + min);
    } else if (command.equalsIgnoreCase("sell")) {
      System.out.println("How much fish do you want to sell?");
      try {
        Scanner c = new Scanner(System.in);
        int sell = c.nextInt();
        fishing.sellFish(sell);
      } catch (Exception inputMismatchException) {
        System.out.println("Please enter an integer.");
        Scanner d = new Scanner(System.in);
        int newSell = d.nextInt();
        fishing.sellFish(newSell);
      }
    } else if (command.equalsIgnoreCase("fish")) {
      System.out.println("You have a total of " + fishing.numFish() + " fish.");
    } else if (command.equalsIgnoreCase("gold")) {
      System.out.println("You have " + fishing.getGold() + " gold.");
    } else if (command.equalsIgnoreCase("coinflip")) {
      System.out.println("How much gold do you want to bet?");
    } else if (command.equalsIgnoreCase("blackjack")) {
      System.out.println("How much gold would you like to bet?");
    } else if (command.equalsIgnoreCase("end")) {
      System.out.println("The game has ended.");
    } else if (command.equalsIgnoreCase("command")) {
        System.out.println("Type \"catch\" to catch some fish. \nType \"sell\" to sell fish. \nType \"fish\" to check how much fish you have. \nType \"gold\" to view your balance. \nType \"coinflip\" to bet some gold. \nType \"command\" to view the commands. \nType \"end\" to end this game.");
    } else {
      System.out.println("Please try again.");
    }
  }

  public void coinFlip() {
    Scanner e = new Scanner(System.in);
    int gold = e.nextInt();
    System.out.println("Heads or tails?");
    Scanner f = new Scanner(System.in);
    String HorT = f.nextLine();
    int max = 1;
    int min = 0;
    int coinSide = (int)(Math.random() * (max - min + 1)) + min;
    if (HorT.equalsIgnoreCase("heads") || HorT.equalsIgnoreCase("h")) cfBet = 0;
    else if (HorT.equalsIgnoreCase("tails") || HorT.equalsIgnoreCase("t")) cfBet = 1;
    if (fishing.getGold() >= gold) fishing.addGoldFromCF(cfBet, gold, coinSide);
    else System.out.println("You do not have enough gold. Type \"catch\" to catch some fish or \"sell\" to sell fish for gold!");
  }

  public void blackjack() {
    Scanner g = new Scanner(System.in);
    bjBet = g.nextInt();
    blackjack = new Blackjack();
    if (fishing.getGold() >= bjBet) {
      if (blackjack.getPlayerWin()) fishing.addGoldFromBJ(bjBet);
      else if (!blackjack.getPlayerWin()) fishing.removeGoldFromBJ(bjBet);
      else System.out.println("No gold was lost or gained.");
    } else {
      System.out.println("You do not have enough gold. Type \"catch\" to catch some fish or \"sell\" to sell fish for gold!");
    }
  }
}
