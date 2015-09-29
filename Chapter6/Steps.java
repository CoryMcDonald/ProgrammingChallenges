import java.util.*;
class Main
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      scan.nextLine();
      while(scan.hasNextLine())
      {
         String line = scan.nextLine();
         String[] inputs = line.split(" ");
         try
         {
            long x = Long.parseLong(inputs[0]);
            long y = Long.parseLong(inputs[1]);
            System.out.println(Step(x, y));
         }
         catch(Exception ex)
         {
            System.out.println(0);
         }
      }
   }
   
   public static int Step(long x, long y)
   {
      int step = 1;
		int count = 0;
      while(x < y)
		{
		   count++;
			x += step;
			
			if(x < y)
			{
			   count++;
				y -= step;
			}
	
			step++;
		}
		return count;
   }
}