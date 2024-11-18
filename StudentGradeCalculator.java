import java.util.ArrayList;
import java.util.Scanner;
public class StudentGradeCalculator{
  public static void main(String[] args){
  
      Scanner input=new Scanner(System.in);
      ArrayList<Double>marksList=new ArrayList<Double>();
      
      System.out.println("Enter number of subjects: ");
        int list=input.nextInt();
      for(int i=0;i<list;i++){
         System.out.println("Enter marks (%)for subject "+(i+1));
          double subjects=input.nextDouble();
          marksList.add(subjects);
       }
           System.out.print("Marks");
           System.out.print(marksList.toString());
           System.out.println();
      
       double total=0;
        double average=0;

    for(int p=0;p<marksList.size();p++){
      total+=marksList.get(p);
       average=total/marksList.size();
  
    }
      System.out.println("Total Marks="+total);
      System.out.println("Average=  "+average+" %");
      
    if(average>=80 && average<=100){
         System.out.println("Grade :A");
         
      }else if(average>=70 && average<=79){
         System.out.println("Grade: B");
         
      }else if(average>=60 && average<69){
         System.out.println("Grade:  C");
         
      }else if(average>=50 && average<=59){
         System.out.println("Grade : D");
         
       }else if(average>=40 && average<=49){
         System.out.println("Grade : E");
         
    }else{
     System.out.println("Grade:  F");
     }

  
 }
}