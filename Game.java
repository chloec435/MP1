import java.util.Scanner;
import java.lang.Math;
public class Game {
  private Fishing fishing;
  private Player player;
  // private String fish;
  // private String gold;
  public Game() {
    fishing = new Fishing();
    // System.out.println("Type start to start the game.");
    // Scanner a = new Scanner(System.in);
    // String start = a.nextLine();
    playerInfo();
    Scanner a = new Scanner(System.in);
    String command = a.nextLine();
    while(!(command == "end")) {
      Scanner b = new Scanner(System.in);
      command = b.nextLine();
      commands(command);
      if (command.equals("end"))
      {
      //   System.out.println("The game has ended.");
      break;
      }
    }
  }
  
  public void playerInfo() {
    System.out.println("Enter a user name:");
    Scanner c = new Scanner(System.in);
    String name = c.nextLine();
    System.out.println("Hello " + name + ". Type \"fish\" to catch some fish. Type \"gold\" to view your balance. Type \"end\" to end this game.");
    player = new Player(name);
  }
  
  public void commands(String command) {
    Scanner d = new Scanner(System.in);
    command = d.nextLine();
    int max = 10;
    int min = 1;
    int range = max - min + 1;
    if (command.equals("fish")) {
      // int max = 10;
      // int min = 9;
      // int range = max - min + 1;
      fishing.catchFish((int)(Math.random() * range) + min);
    } else if (command.equals("gold")) {
      System.out.println("You have " + player.checkGold() + " gold.");
    } else if (command.equals("end")) {
      System.out.println("The game has ended.");
      // break;
    } else {
      System.out.println("Please try again.");
    }
  }
  
  public void returnGold() {
    System.out.println("Total gold: " + player.checkGold());
  }
}
