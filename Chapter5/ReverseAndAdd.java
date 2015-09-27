import java.math.*;
import java.util.*;

class Main
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      scan.nextLine();
      while(scan.hasNextLine())
      {
         int count = 0;
         long number = Integer.parseInt(scan.nextLine());
         do
         {
            count++;
   			long reverse = reverse(number);
   			number = number + reverse;
         }
         while(!isPalindrome(number));
         System.out.println(count + " " + number);
      }
   }
   public static long reverse(long number)
   {
      long resultNumber = 0;
      for(long i = number; i !=0; i /= 10) {
        resultNumber = resultNumber * 10 + i % 10;
      }
      return resultNumber;
   }
	public static boolean isPalindrome(long number) {
		return Long.toString(number).equals(new StringBuffer(Long.toString(number)).reverse().toString());
	}
}