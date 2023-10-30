import java.util.Scanner;
import java.util.Random;
public class Blackjack {
  private int playerTotal;
  private int dealerTotal;
  private String response;
  private boolean playerWin;
  public Blackjack(String a) {
  }   
  public Blackjack() {
    deal();
    ask();
    compareTotal();
  }
  public void deal() {
    Random random = new Random();
    int playerCard1 = random.nextInt(10) + 1;
    int playerCard2 = random.nextInt(10) + 1;
    int dealerCard1 = random.nextInt(10) + 1;
    int dealerCard2 = random.nextInt(10) + 1;
    playerTotal = playerCard1 + playerCard2;
    dealerTotal = dealerCard1 + dealerCard2;
  }
  public void ask() {
    System.out.println("Your total is " + playerTotal + ". Would you like to hit (yes/no)?");
    Scanner scanner = new Scanner(System.in);
    response = scanner.nextLine();
    if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
      playerHit();
    } else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")) {
      System.out.println("The dealer's total is " + dealerTotal + ".");
      if (dealerTotal < 17) dealerHit(); 
      else System.out.println("The dealer has chosen to stay.");
    }
  }
  public void playerHit() {
    Random random = new Random();
    int playerCard3 = random.nextInt(10) + 1;
    playerTotal += playerCard3;
    System.out.println("Your new card is " + playerCard3 + ". Your total is now " + playerTotal + ".");
    if (playerTotal > 21) {
      System.out.println("You busted! Dealer wins.");
      playerWin = false;
    } else if (playerTotal == 21) {
      System.out.println("You got a Blackjack! Dealer's turn.");
      dealerHit();
    } else if (playerTotal < 21) {
      ask();
    }
  }
  public void dealerHit() {
    Random random = new Random();
    int dealerCard3 = random.nextInt(10) + 1;
    dealerTotal += dealerCard3;
    System.out.println("The dealer's new card is " + dealerCard3 + ". Their total is now " + dealerTotal + ".");
    if (dealerTotal > 21) {
      System.out.println("The dealer busted! You win!");
      playerWin = true;
    } else if (dealerTotal == 21) {
      System.out.println("The dealer got Blackjack!");
      playerWin = false;
    } else if (dealerTotal < 17) {
      dealerHit();
    }
  }
  public void compareTotal() {
    if (playerTotal > dealerTotal && playerTotal <= 21) {
      System.out.println("You win!");
      playerWin = true;
    } else if (playerTotal < dealerTotal && dealerTotal <= 21) {
      System.out.println("Dealer wins!");
      playerWin = false;
    } else if (playerTotal == dealerTotal && (dealerTotal <= 21 && playerTotal <= 21)) {
      System.out.println("It's a draw!");
    }
  }
  public int getPlayerTotal() {
    return playerTotal;
  }
  public int getDealerTotal() {
    return dealerTotal;
  }
  public boolean getPlayerWin() {
    return playerWin;
  }
}
