import java.util.*;
import java.io.*;

class Main {

   private static int[] xl = new int[150];
	private static int[] yl = new int[150];
	private static int n = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in );
		int a, b;
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			for (int i = 0; i < 2 * n; i++) {
				xl[i] = sc.nextInt();
				yl[i] = sc.nextInt();
			}
			a = 0;
			b = 1;
			if (!check(0, 1)) {
				a = 1;
				for (a = 1; a <= 500; a++) {
					for (b = -500; b <= 500; b++) {
						if (check(a, b)) {
							n = 0;
							break;
						}
					}
					if (n == 0) {
						break;
					}
				}
			}
			System.out.printf("%d %d%n", a, b);
		}
	}

	static boolean check(int a, int b) {
		int l, r;
		int t;
		l = r = 0;
		for (int i = 0; i < n * 2; i++) {
			t = a * xl[i] + b * yl[i];
			if (t < 0) {
				l++;
			}
			if (t > 0) {
				r++;
			}
		}
		if (l == r && l == n) {
			return true;
		}
		return false;
	}

}