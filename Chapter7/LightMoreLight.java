import java.util.*;
class Main
{
    public static void main(String[] args) {
      long numLights = 0;
      Scanner scan = new Scanner(System.in);
      while ((numLights = Long.parseLong(scan.nextLine())) != 0)
      {
            if (isPerfectSquare(numLights)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
     }
   }
     public static boolean isPerfectSquare(long n) {
     long squareRoot = (long) Math.sqrt(n);
     return squareRoot * squareRoot == n;
   }
}