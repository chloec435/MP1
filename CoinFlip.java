// import java.util.Scanner;
// public class CoinFlip {
//   private int headsOrTails;
//   private int coin;
//   private Fishing gfcf;
//   public void flip(String HorT) {
//     Scanner one = new Scanner(System.in);
//     System.out.println("How much do you want to bet?");
//     int wager = one.nextInt();
//     gfcf = new Fishing();
//     int max = 1;
//     int min = 0;
//     int range = max - min + 1;
//     int bet = (int)(Math.random() * range) + min;
//     coin = bet;
//     if (HorT.equals("heads") || HorT.equals("h")) {
//       headsOrTails = 0;
//     } else if (HorT.equals("tails") || HorT.equals("t")) {
//       headsOrTails = 1;
//     }
//     if (headsOrTails == bet) {
//       System.out.println("Congrats! You have guessed right!");
//       gfcf.addGoldFromCF(wager);
//     } else {
//       System.out.println("Sorry, better luck next time!");
//       gfcf.addGoldFromCF(wager);
//     }
//   }
//   public int headsOrTails() {
//     return headsOrTails;
//   }
//   public int getCoin() {
//     return coin;
//   }
// }
