import java.util.*;

class Main
{
   public static void main(String[] args)
   {
      int max = -1;
		int maxIndex = -1;
      Scanner scan = new Scanner(System.in);
      while(scan.hasNextLine())
      {
         
         String line = scan.nextLine();
         String[] temp=  line.split(" ");
         int[] lineInt = new int[temp.length];
         for(int i = 0; i< lineInt.length; i++)
            lineInt[i] = Integer.parseInt(temp[i]);
       
		   System.out.println(line);
         for (int i = temp.length - 1; i >= 0; i--) {
				max = Integer.MIN_VALUE;
				
				for (int j = 0; j <= i; j++) {
					if (max <= lineInt[j]) {
						max = lineInt[j];
						maxIndex = j;
					}
				}
				
				if (maxIndex != i) {
					if (maxIndex != 0) {
						System.out.print(temp.length - maxIndex + " ");
							
						for (int j = 0; j <= maxIndex/2; j++) {
							lineInt = swap(lineInt, j, maxIndex - j);
						}
					}
					
					System.out.print(temp.length - i + " ");
					
					for (int j = 0; j <= i/2; j++) {
						lineInt = swap(lineInt, j, i - j);
					}
				}
			}
			System.out.println("0");
			
      }
   }
   
   public static int[] swap(int[] array, int index1, int index2)
   {
      int temp = array[index1];
      array[index1] = array[index2];
      array[index2] = temp;
      return array;
   }
}