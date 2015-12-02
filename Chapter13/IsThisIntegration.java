import java.io.*;
import java.util.*;

class Main
{
   public static void main(String[] args)
   {
      try{
         double a,x,y,z;
         Scanner scan = new Scanner(System.in);
         while(scan.hasNextLine())
         {
            a = scan.nextDouble();
      		double Aria=Math.PI*a*a/12 - Math.sin(Math.PI/6)*a*a/2;
            double b = a*Math.sqrt(2)/(Math.sqrt(3)+1);
      		x=b*b+4*Aria;
      		y=4*(Aria+b*b*Math.sin(Math.PI/3)/2);
      		z=4*(b*b*Math.sin(Math.PI/6)/2-2*Aria);
      		System.out.printf("%.3f %.3f %.3f\n",x,y,z);
         }
      }catch(Exception ex) { }
   }
}