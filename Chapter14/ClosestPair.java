import java.io.*;
import java.text.*;
import java.util.*;


class Main {

	static double[][] coordinates;

	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder();
      Scanner sc = new Scanner(System.in);
      while (sc.hasNextLine())
      {
         String input = sc.nextLine();
			int N = Integer.parseInt(input);
			if (N == 0) break;
			coordinates = new double[N][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				coordinates[i][0] = Double.parseDouble(st.nextToken());
				coordinates[i][1] = Double.parseDouble(st.nextToken());
			}

			Arrays.sort(coordinates, new Comparator < double[] > () {
				public int compare(double[] o1, double[] o2) {
					if (o1[0] < o2[0]) return 1;
					if (o2[0] < o1[0]) return -1;
					return 0;
				}
			});

			double dis = dyc(0, coordinates.length - 1);
			DecimalFormatSymbols s = new DecimalFormatSymbols();
			s.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("0.0000", s);
			double val = 10000.0000;
			if (dis > val) sb.append("INFINITY\n");
			else sb.append(df.format(dis) + "\n");
		}
		System.out.print(new String(sb));
	}

	static double dyc(int Initial, int Final) {
		if (Initial > Final) return Double.MAX_VALUE;
		if (Initial == Final) return Double.MAX_VALUE;
		else if (Initial + 1 == Final) {

			return Distance(coordinates[Initial], coordinates[Final]);
		} else {
			int mid = (Initial + Final) / 2;

			double disRec = Math.min(dyc(Initial, mid), dyc(mid + 1, Final));

			int indInitial;
			int indFinal;
			if (mid - 2 >= 0) indInitial = mid - 2;
			else if (mid - 1 >= 0) indInitial = mid - 1;
			else indInitial = mid;
			if (mid + 2 < coordinates.length) indFinal = mid + 2;
			else if (mid + 1 < coordinates.length) indFinal = mid + 1;
			else indFinal = mid;

			double disFrag = DistanceFormula(indInitial, indFinal);

			return Math.min(disRec, disFrag);
		}
	}

	static double DistanceFormula(int a, int b) {
		double dis = Double.MAX_VALUE;
		if (a < b) {
			for (int i = a; i < b; i++) {
				for (int j = i + 1; j <= b; j++) {
					double dis2 = Distance(coordinates[i], coordinates[j]);
					if (dis2 < dis) dis = dis2;
				}
			}
		}
		return dis;
	}

	static double Distance(double p1[], double p2[]) {
		return Math.sqrt((Math.pow((p2[0] - p1[0]), 2)) + (Math.pow((p2[1] - p1[1]), 2)));
	}

}