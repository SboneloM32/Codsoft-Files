import java.util.Random;
import java.util.Scanner;
public class NumberGame{
public static void numberGame(int attempts ){
Scanner input=new Scanner(System.in);
   int guess=0;
   int count=0;
   int limit=6;
   int bound=100;
   int win =0;
   int loss=0;
  Random rand=new Random();
  int auto=rand.nextInt(bound)+1;
  for(int i=0;i<attempts;i++){
     System.out.println("Guess number between 1 and 100:");
      guess= input.nextInt();
         count++;
       if(guess==auto){
               System.out.println("CORRECT");
               win++;
              break;
      }else if(guess>auto){
           System.out.println("Too high");
           loss++;
     }else {
              System.out.println("Too Low");
              loss++;
       }
      
   }
 
       System.out.println(count+" Attempts made by player.");
       System.out.println(loss+" =Loss ");
      System.out.println(win+" =Wins ");
   if(win>loss){
          System.out.println("Congratulations you Won !!!");
   }else{
          System.out.println("Oops Sorry!! You loose "); 
         }
 
}
  public static void main(String[]args){
  Scanner input=new Scanner(System.in);
    System.out.println("WELCOME TO GUESSING GAME");
    System.out.println("       ");
    System.out.println("1. NEW GAME");
    System.out.println("2. MULTIPLE ROUNDS");
    System.out.println("3. Close Application");
    System.out.println("Select option :");
  int option=input.nextInt();
  switch(option){
    case 1:
      System.out.println("New Game");
      System.out.println("Enter number of attempts :");
      int attempts=input.nextInt();
        
      numberGame(attempts);
      break;
    case 2:
      System.out.println("Multiple rounds");
      System.out.println("Number of rounds: ");
      int round=input.nextInt();
      System.out.println("Enter number of attempts :");
      attempts=input.nextInt();
      for(int i=0;i<round;i++){
         System.out.println("Round "+(i+1));
     //    System.out.println("Guess number between 1 and 100 :");
     // guesslimit= input.nextInt();
         numberGame(attempts);   
         }
      System.out.println("GAME OVER ");     
      System.out.println("Rounds played = "+round);
      break;
     case 3:
       System.out.println("Thanks for using this application.Bye");
        break;
     default:
     System.out.println("Invalid Option");
        break;
 }
 input.close();
 }
 }

