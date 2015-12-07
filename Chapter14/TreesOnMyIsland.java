import java.util.*;
import java.io.*;
import java.math.*;

class Point {
	BigInteger x;
	BigInteger y;
}

class Main {
   static Point[] P = new Point[1100];
   
	static BigInteger Area()
	{
		BigInteger a = new BigInteger("0");
		for (int i = 1; i < N; i++) {
			BigInteger Tmp = P[i].x.multiply(P[i + 1].y).subtract(P[i + 1].x.multiply(P[i].y));
			
		   
			a= a.add(Tmp);
		}
		return a.abs();
	}

	static BigInteger Boundary() {
		BigInteger B = new BigInteger("0");
		B = B.subtract(new BigInteger(String.valueOf(N)));
		for (int i = 1; i <= N; i++) {
			BigInteger X = P[i].x.subtract(P[i + 1].x);
			BigInteger Y = P[i].y.subtract(P[i + 1].y);
			BigInteger Tmp = X.abs().gcd(Y.abs()).add(BigInteger.ONE);
			B = B.add(Tmp);
		}
		return B;
	}

   static int N = 0;
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int i =0;
      
      while(sc.hasNextLine())
      {
         String[] line = sc.nextLine().split(" ");
         if(line.length == 1)
         {
            if(i!=0)
            {
               N = i;
               P[i + 1] = P[1];
               System.out.println((Area().subtract(Boundary()).add(new BigInteger("2"))).divide(new BigInteger("2")));
            }
            i =0;
            Point temp = new Point();
            temp.x =  BigInteger.ZERO;
            temp.y =  BigInteger.ZERO;
            Arrays.fill(P, temp);
         }
         else
         {
            // System.out.println("Creating new point:" + i);
            P[i] = new Point();
            P[i].x = new BigInteger(line[0]);
            P[i].y = new BigInteger(line[1]);
            i++;
         }
      }
// 		while (true) {
// 			for (int i = 1; i <= N; i++) {
// 				fscanf(f, "%lld %lld", & P[i].x, & P[i].y);
// 			}
// 			P[N + 1] = P[1];
// 			System.out.println((Area() - Boundary() + 2) / 2);
// 		}
	}
}