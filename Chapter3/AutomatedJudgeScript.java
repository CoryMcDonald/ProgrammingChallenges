
// ---------- Forwarded message ----------
// From: UVa Online Judge <noreply@onlinejudge.org>
// Date: Tue, Sep 8, 2015 at 10:49 AM
// Subject: Submission 16066586 - Accepted
// To: Cory McDonald <cxm072@email.uark.edu>


// Hi,

// This is an automated response from UVa Online Judge.

// Your submission with number 16066586 for the problem 10188 - Automated Judge Script has succeeded with verdict Accepted.

// Congratulations! Now it is time to try a new problem.

// Best regards,

// The UVa Online Judge team

//Automated Judge Script
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