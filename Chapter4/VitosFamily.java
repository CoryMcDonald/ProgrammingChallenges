import java.util.*;

class Main
{
   public static void main(String[] args)
   {
      
      Scanner scan = new Scanner(System.in);
      int runs = scan.nextInt();
      
      for(int run=0; run<runs;run++)
      {
         int sum = 0;
         int arraySize = scan.nextInt();
         int[] array = new int[arraySize];
         for(int i=0; i<arraySize;i++)
            array[i] = scan.nextInt();
            
         int temp[] = array.clone();
         Arrays.sort(temp);
         int median = temp[array.length/2];
         
         for(int element : array)
         {
            sum+= Math.abs(median-element);
         }
         System.out.println(sum);
      }
   }
}