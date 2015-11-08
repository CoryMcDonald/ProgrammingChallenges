import java.io.File;
import java.util.Scanner;

class Main
{

	public static int max = 10000 + 5;
	public static int numPeople, op, first, second;
	public static int[] parents = new int[max + max + 1];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System. in );
		numPeople = sc.nextInt();
		for (int i = 1; i <= (max + max); i++) {
			parents[i] = i;
		}

		while (sc.hasNext()) {
			op = sc.nextInt();
			first = sc.nextInt();
			second = sc.nextInt();
			if (op == 0 && first == 0 && second == 0) {
				break;
			}
			if (op == 1) {
				setAllies(first, second);
			}
			if (op == 2) {
				setAxis(first, second);
			}
			if (op == 3) {
				areAllies(first, second);
			}
			if (op == 4) {
				areAxis(first, second);
			}

		}

	}

	public static int findSet(int i) {
		if (parents[i] == i) {
			return i;
		} else {
			return parents[i] = findSet(parents[i]);
		}
	}

	public static void setAllies(int X, int Y) {
		int A1, B1, A2, B2;
		A1 = findSet(X);
		A2 = findSet(Y);
		B1 = findSet(X + numPeople);
		B2 = findSet(Y + numPeople);

		if (A1 == B2 || A2 == B1) {
			System.out.println("-1");
		} else {
			parents[A2] = A1;
			parents[B2] = B1;
		}
	}

	public static void areAllies(int X, int Y) {
		if (findSet(X) == findSet(Y)) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}

	public static void setAxis(int X, int Y) {
		int A1, B1, A2, B2;
		A1 = findSet(X);
		A2 = findSet(Y);
		B1 = findSet(X + numPeople);
		B2 = findSet(Y + numPeople);

		if (A1 == A2) {
			System.out.println("-1");
		} else {
			parents[B1] = A2;
			parents[B2] = A1;
		}
	}

	public static void areAxis(int X, int Y) {
		int A1, B1, A2, B2;
		A1 = findSet(X);
		A2 = findSet(Y);
		B1 = findSet(X + numPeople);
		B2 = findSet(Y + numPeople);

		if (A1 == B2 || A2 == B1) {
			System.out.println("1");
		} else {
			System.out.println("1");
		}
	}


}