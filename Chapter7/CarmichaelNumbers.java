import java.util.*;

class Main
{
   
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
       ArrayList<Integer> carmichaelNumbers =  new ArrayList<Integer>(Arrays.asList(561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041, 46657, 52633, 62745, 63973));
      while(scan.hasNextLine())
      {
         int currentNumber = Integer.parseInt(scan.nextLine());
         if(currentNumber != 0)
         {
            if(carmichaelNumbers.contains(currentNumber))
            {
               System.out.println("The number "+ currentNumber+" is a Carmichael number.");
            }else
            {
               System.out.println(currentNumber + " is normal.");
            }
         
         }
      }
      
   }
}