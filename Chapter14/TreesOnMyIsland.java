import java.util.*;
import java.io.*;
import java.math.*;

class Point {
	BigInteger x;
	BigInteger y;
}

class Main {
   static Point[] P = new Point[1100];
   
	static BigInteger Area() {
		BigInteger a = new BigInteger("0");
		for (int i = 1; i <= N; i++) {
			BigInteger Tmp = P[i].x.multiply(P[i + 1].y).subtract(P[i + 1].x.multiply(P[i].y));
			a.add(Tmp);
		}
		return a.abs();
	}

	static BigInteger Boundary() {
		BigInteger B = new BigInteger("0");
		B.subtract(new BigInteger(String.valueOf(N)));
		for (int i = 1; i <= N; i++) {
			BigInteger X = P[i].x.subtract(P[i + 1].x);
			BigInteger Y = P[i].y.subtract(P[i + 1].y);
			BigInteger Tmp = X.abs().gcd(Y.abs()).add(BigInteger.ONE);
			B.add(Tmp);
		}
		return B;
	}

   static int N = 0;
	public static void Main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      while(sc.hasNextLine())
      {
         for(int i=0; i<= N; i++)
         {
            String[] line = sc.nextLine().split(" ");
            P[i] = new Point();
            P[i].x = new BigInteger(line[0]);
            P[i].y = new BigInteger(line[1]);
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