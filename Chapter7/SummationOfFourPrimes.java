import java.util.*;
class Main
{
   public static void main(String[] args)
   {
      boolean primes[] = sieveOfEratosthenes();
      Scanner scan = new Scanner(System.in);
      while(scan.hasNextLine())
      {
         int num = Integer.parseInt(scan.nextLine());

         if (num < 8)
         {
            System.out.println("Impossible.");
         }
         else
         {
             if (num % 2 == 0)
             {
                 System.out.print("2 2 ");
                 num -= 4;
             } else
             {
                 System.out.print("2 3 ");
                 num -= 5;
             }

             int i;
             for (i = 2; i < num; ++i)
             {
                 if (!primes[i] && !primes[num - i])
                 {
                     break;
                 }
             }
             System.out.println(i + " " + (num - i));
         }
      }
   }

   private static boolean[] sieveOfEratosthenes()
   {
     boolean[] primes = new boolean[10000001];
     int end = (int)Math.sqrt(10000001)+1;
   
     for(int i = 2; i <= end; ++i)
     {
         if(!primes[i]) {
             for(int j = i+i; j < 10000001; j += i)
             {
                 primes[j] = true;
             }
         }
     }
   
     primes[0] = true;
     primes[1] = true;
   
     return primes;
   }
   
   
}