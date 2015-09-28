import java.util.*;

class Main
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      while(scan.hasNextLine())
      {
         String line = scan.nextLine();
         if(!line.equals("0 0"))
            System.out.println(formatCarryOperations(CarryOperations(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1]))));
      }
   }
   
   public static int CarryOperations(int number1, int number2) {
		if (number1 == 0 || number2 == 0)
		{
			return 0;
		}
		if (number1 % 10 + number2 % 10 >= 10)
		{
			return 1 + CarryOperations(number1 / 10, 1) + CarryOperations(number1 / 10 +1,number2 / 10);
		}
		return CarryOperations(number1 / 10, number2 / 10);
	}
   
   public static String formatCarryOperations(int carryOperations)
   {
      String returnValue = "No carry operation.";
      if(carryOperations > 0)
      {
         returnValue = carryOperations + " carry ";
         if(carryOperations == 1)
            returnValue += "operation.";
         else
            returnValue += "operations.";
      }
      return returnValue;
   }
}