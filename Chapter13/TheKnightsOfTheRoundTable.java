import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();

			if (a == 0 || b == 0 || c == 0) {
				System.out.println("The radius of the round table is: 0.000");
			} else {
				double s = (a + b + c) / 2;
				double radio = Math.sqrt(((s - a) * (s - b) * (s - c) / s));
				System.out.printf("The radius of the round table is: %.3f\n", radio);
			}
		}
	}
}