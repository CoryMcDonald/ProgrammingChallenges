import java.math.*;
import java.util.*;
class Main
{

   public static void main(String[] args)
   {
      //Initialize given values;
      m[1] = new BigInteger("2");
      m[2] = new BigInteger("5");
      m[3] = new BigInteger("13");
      Scanner scan = new Scanner(System.in);
      while(scan.hasNextLine())
         System.out.println(Count(Integer.parseInt(scan.nextLine())));
   }

   private static BigInteger[] m = new BigInteger[1000000];
   public static BigInteger Count(int n)
   {
      if(n==1) return m[1];
      else if(n==2) return m[2];
      else if(n == 3) return m[3];
      else
      {
         if(m[n-2] == null) m[n-2] = Count(n-2);
         if(m[n-3] == null) m[n-3] = Count(n-3);
         return Count(n-1).multiply(m[1]).add(m[n-2]).add(m[n-3]);
      }
   }
}