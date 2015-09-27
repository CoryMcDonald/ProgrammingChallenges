import java.util.*;
import java.io.*;

class Main
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine())
		{
		   StringTokenizer st = new StringTokenizer(scan.nextLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
         int[] factorials = new int[13];
         
         // Declare value to store answer
         int denominator = 1;
         
         // Get the line of coefficients
         st = new StringTokenizer(scan.nextLine());
         
         // Iterate over the array
         for (int i = 1; i <= k; ++i)
         {
            denominator *= factorial(Integer.parseInt(st.nextToken()));
         }
         // calculate final answer using the formula above.
         int answer = factorial(n) / denominator;
         
   	   System.out.println(answer);
      }
   }
   public static int factorial(int n) {
     int fact = 1;
     for (int i = 1; i <= n; i++) {
         fact *= i;
     }
     return fact;
   }
   
}