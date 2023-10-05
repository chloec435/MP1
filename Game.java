import java.util.Scanner;
public class Game {
  private Fishing fishing;
  private Player player;
  private int bet;
  // private CoinFlip coinflip;
  public Game() {
    fishing = new Fishing();
    playerInfo();
    String command = "start";
    while(!(command == "end")) {
      Scanner a = new Scanner(System.in);
      command = a.nextLine();
      commands(command);
      if (command.equals("coinflip")) { coinFlip(); }
      if (command.equals("end")) { break; }
    }
  }
  
  public void playerInfo() {
    System.out.println("Enter a user name:");
    Scanner b = new Scanner(System.in);
    player = new Player(b.nextLine());
    System.out.println("Hello " + player.getName() + ". \nType \"catch\" to catch some fish. \nType \"sell\" to sell fish. \nType \"fish\" to check how much fish you have. \nType \"gold\" to view your balance. \nType \"coinflip\" to bet some gold. \nType \"command\" to view the commands. \nType \"end\" to end this game.");
  }
  
  public void commands(String command) {
    int max = 100;
    int min = 10;
    int range = max - min + 1;
    if (command.equals("catch")) {
      fishing.catchFish((int)(Math.random() * range) + min);
      
    } else if (command.equals("sell")) {
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
      
    } else if (command.equals("fish")) {
      System.out.println("You have a total of " + fishing.numFish() + " fish.");
      
    } else if (command.equals("gold")) {
      System.out.println("You have " + fishing.getGold() + " gold.");

    } else if (command.equals("coinflip")) {
      System.out.println("Heads or tails?");
      
    } else if (command.equals("end")) {
      System.out.println("The game has ended.");
      
    } else if (command.equals("command")) {
        System.out.println("Type \"catch\" to catch some fish. \nType \"sell\" to sell fish. \nType \"fish\" to check how much fish you have. \nType \"gold\" to view your balance. \nType \"coinflip\" to bet some gold. \nType \"command\" to view the commands. \nType \"end\" to end this game.");
      
    } else {
      System.out.println("Please try again.");
    }
  }

  public void coinFlip() {
    // coinflip = new CoinFlip();
    Scanner e = new Scanner(System.in);
    String HorT = e.nextLine();
    int max = 1;
    int min = 0;
    int range = max - min + 1;
    int coinSide = (int)(Math.random() * range) + min;
    if (HorT.equals("heads") || HorT.equals("h")) {
       bet = 0;
     } else if (HorT.equals("tails") || HorT.equals("t")) {
       bet = 1;
     }
    Scanner f = new Scanner(System.in);
    System.out.println("How much gold do you want to bet?");
    fishing.addGoldFromCF(bet, f.nextInt(), coinSide);
  }
}
