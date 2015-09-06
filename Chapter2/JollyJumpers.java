import java.util.*;
import java.io.*;
// 10038 - Jolly Jumpers
class Main
{
   public static void main(String[] args)
   {
      boolean DebugMode = false;
      Scanner scan = new Scanner(System.in);
      while(scan.hasNext())
      {
         boolean Valid = true;
         String[] numbers = scan.nextLine().split(" ");
         int[] Jumpers = new int[numbers.length];
			boolean[] diffList = new boolean[numbers.length];
			if(DebugMode)
			   System.out.println(Arrays.toString(numbers));
         for(int i=1; i< numbers.length ; i++)
         {
            Jumpers[i] = Integer.parseInt(numbers[i]);
            if(i >  1)
            {
               if(DebugMode)
               {
                  System.out.print(Jumpers[i] + "-" + Jumpers[i-1]);
                  System.out.print(" = ");
                  System.out.print(Math.abs(Jumpers[i]-Jumpers[i-1]) + "\n");
               }
               int result = Math.abs(Jumpers[i]-Jumpers[i-1]);
               if(result == 0 || result >= numbers.length-1 || diffList[result])
                  Valid = false;
               else
                  diffList[result] = true;
            }
         }
         if(DebugMode)
            System.out.print(Arrays.toString(numbers) + ": ");
         if(Valid)
         {
            
            System.out.println("Jolly");
         }else
         {
            System.out.println("Not jolly");
         }
         
      }
   }
}