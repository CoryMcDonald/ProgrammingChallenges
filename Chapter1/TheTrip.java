import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			while (scan.hasNextLine()) {
				int numStudents = scan.nextInt();

				if (numStudents == 0) {
					break;
				}

				double[] expenditures = new double[numStudents];
				double sumExpenditures = 0;
				for (int i = 0; i < numStudents; i++) {
					expenditures[i] = scan.nextDouble();
					sumExpenditures += expenditures[i];
				}

				double averageExpense = Math.round((sumExpenditures / (double) numStudents) * 100.00) / 100.0;
        
				double positiveSum = 0, negativeSum = 0;
				for (int i = 0; i < numStudents; i++) {
					double difference = expenditures[i] - averageExpense;
          
					if (difference < 0) {
						negativeSum -= difference;
					} else {
						positiveSum += difference;
					}
				}

				double payment = 0;
				if (negativeSum < positiveSum) {
					payment = negativeSum;
				} else {
					payment = positiveSum;
				}
        
				System.out.printf("$%.2f\n", payment);
			}
		} catch (Exception e) {}
		
	}
}