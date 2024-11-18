import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class AccountInfo{

private String name;
private String accNo;
private double amount;
private String password;
public AccountInfo(){
 this.name="";
  this.accNo="";
  this.amount=0.0;
  this.password="";
}
public AccountInfo(String name,String accNo,double amount,String password){
 this.name=name;
  this.accNo=accNo;
  this.amount=amount;
  this.password=password;
}
public void setName(String name){
  this.name=name;
}
public String getName(){
  return name;
}
public void setAcc(String accNo){
   this.accNo=accNo;
 }
 public String getA(){
  return accNo;
 }
 public void setPassword(String password){
   this.password=password;
 }
 public String getPassword(){
  return password;
 }
 public void setAmount(double amount){
  if(amount>0 ){
     this.amount=amount;
  }else{
     System.out.println("Invalid amount !!");
 }
 }
 public double getCash(){
   return amount;
 }
 public String toString(){
 
 return "Account owner :"+name+"\nAccount Number: "+"Initial Balance=R"+amount;
 }
 
 public void create(){
  Scanner crt=new Scanner(System.in);
    System.out.println("Enter username :");
     this.name=crt.nextLine();
     System.out.println("Enter Account Number :");
      this.accNo=crt.nextLine();
     System.out.println("Enter password :");
      this.password=crt.nextLine();
     System.out.println("Account created !!");
  saveAccount();
 }
 public boolean Sign(String userN ,String P){
   return userN.equals(name) && P.equals(password);
 }
 public void saveAccount(){
   try(BufferedWriter wr=new BufferedWriter(new FileWriter("Accounts.txt",true))){
   System.out.println(" Account owner :"+this.name);
   System.out.println("Account number :"+this.accNo);
   System.out.println("Initialiseed Balance:"+this.amount);
  
  
   wr.write("Account Owner: "+this.name);  
   wr.newLine();
     wr.write("Account Number: "+this.accNo);
       wr.newLine();
       wr.write("Initial Balance: "+this.amount);
       wr.newLine();
       wr.newLine();
 
 }catch(IOException e){
   System.out.println("Account not saved retry!!");
 }

   }
   public static void readAccount(String username,String accountNumber){
     try(BufferedReader rd=new BufferedReader(new FileReader("Accounts.txt"))){
      String line="";
       boolean founded=false;
        while((line=rd.readLine())!=null){
         if(line.contains("Acccount ownwer")){
          String named=line.substring(14);
          String accNod=rd.readLine().substring(16);
           String accB=rd.readLine().substring(20);
          if(named.equals(username) && accNod.equals(accountNumber)){
           System.out.println("Account found");
           System.out.println("Account owner");
           System.out.println("Account number");
           System.out.println("Account balance");
            founded=true;
            break;    
      }
   }
   if(!founded){
     System.out.println("account does not exist");
     }
     }
   }catch(IOException e){
     System.out.println("Error");
   }
   }
   }
 
       
  
 
 