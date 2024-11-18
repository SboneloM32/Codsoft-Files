import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Atm{
private double money =0;
private static double balance=100.0;
public static void getWithdrawal(double money){
 readingBalance();
  if(money<balance){
   balance=balance-money;
    System.out.println("Withdrawal Successful !!");
    System.out.println("New balance after widthrawal =R"+balance);
  }else{
     System.out.println("Insufficient funds !!");
  }
 }
 public static void getDeposit(double deposit){
     balance=balance+deposit;
     System.out.println("Deposit Successful !!");
     System.out.println("Available balance after Deposit =R"+balance);   
  }
  public static void getBalance(){
    System.out.println("Remaining Balance ="+balance);
  }
  public static void storeBalance(){
   try(BufferedWriter wr=new BufferedWriter(new FileWriter("balances.txt"))){
   wr.write(Double.toString(balance));
   }catch(IOException e){
     System.out.println("Balance not saved ");
   }
  
  }
  
 public static void readingBalance(){
   try(BufferedReader read =new BufferedReader(new FileReader("balances.txt"))){
      String balances=read.readLine();
      if(balances !=null){
        balance=Double.parseDouble(balances);
      }else{
         balance=100.0;
   }
   }catch(IOException e){
     System.out.println("Balance not retrieved ");
     balance=100.0;
 
 }
 }
public static void main(String[] args){
AccountInfo ac=new AccountInfo();
Scanner px=new Scanner(System.in);
System.out.println("1 .Create Account ");
System.out.println("2 .Withdraw ");
System.out.println("3 .Deposit ");
System.out.println("4 .Check Balance ");
System.out.println("5 .Login");
System.out.println("Select an option :");
int option=px.nextInt();
switch(option){
  case 1:
       System.out.println("Create Account ");     
      ac.create(); 
                
    break;
  case 2:
      System.out.println("Withdrawal Proceeding");
      System.out.println("Enter amount to withdraw:");
      double withdraw=px.nextDouble();
      getWithdrawal(withdraw);
      storeBalance();
    break;
  case 3:
      System.out.println("Deposit amount :");
      double deposit=px.nextDouble();
      getDeposit(deposit);
      storeBalance();
     break;
  case 4:
     System.out.println("Available balance");
     readingBalance();
     getBalance();
     
     break;
 case 5:
   
   System.out.println("Enter Username ");
   String uname=px.next();
   System.out.println("Enter Password ");
   String upassword=px.next();
     
     if(uname.equals(ac.getName()) && upassword.equals(ac.getPassword())){
        System.out.println("Signing in");
           System.out.println("Signed in account of :"+ac.getName());
           System.out.println("Enter account number");
           String accNo=px.nextLine();
           AccountInfo.readAccount(uname,accNo);
         }
         else{
          System.out.println("No account found");
        }  
     break;
      default:
     break;
   }   
   px.close();
}
}

