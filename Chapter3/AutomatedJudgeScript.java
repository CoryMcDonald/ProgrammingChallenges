import java.util.*;
import java.io.*;
class Main
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int run = 1;
      while(scan.hasNextLine())
      {
         int linesOfSolution = scan.nextInt();
         if(linesOfSolution ==0)
            break;
            
         String solution = "";
         for(int i=0; i<=linesOfSolution; i++)
            solution += scan.nextLine();
         
         String student = "";
         int linesOfStudent = scan.nextInt();
         for(int i=0; i<=linesOfStudent; i++)
            student += scan.nextLine();
         
         System.out.print("Run #" + run + ": ");
         if(solution.equals(student) && linesOfStudent == linesOfSolution)
            System.out.println("Accepted");
         else if(solution.replaceAll("[^0-9]","").equals(student.replaceAll("[^0-9]","")))
            System.out.println("Presentation Error");
         else
            System.out.println("Wrong Answer");
         run++;
      }
      
   }
}