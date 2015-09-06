import java.util.*;

class Main
{
   public static void main(String[] args)
   {
		Scanner scan = new Scanner(System.in);
      int trials = scan.nextInt();
      for(int trial = 0; trial < trials; trial++)
      {
         int numOfDays = scan.nextInt();
         int p = scan.nextInt();
         int[] partys = new int[p];
         int hartals = 0;
         
         for(int i =0; i<p; i++) {
            partys[i] = scan.nextInt();
         }
         
         for(int day=1; day<=numOfDays; day++) {
            if(day % 7 != 0 && day % 7 != 6) //Ignore friday and saturday
            {
               boolean hartal = false;
               for(int party : partys) {
                  hartal = hartal || day % party == 0;
               }
               if(hartal)
                  hartals++;
            }
         }
         System.out.println(hartals);
      }
   }


}