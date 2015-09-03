import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextInt()) {
			int i = input.nextInt();
			int j = input.nextInt();
			int start = 0;
			int end = 0;
			int cycleLength = 0;
			if (i < j) {
				start = i;
				end = j;
			} else {
				start = j;
				end = i;
			}
			
			for (int n = start; n <= end; n++) {
				cycleLength = Math.max(cycleLength, getCycleLength(n));
			}
			
			System.out.println(i + " " + j + " " + cycleLength);
		}
	}
	
	public static int getCycleLength(long n) {
		int length;
		if (n == 1) {
			length = 1;
		}else
		{
		  length = 1 + getCycleLength(nextNumber(n));
		}
		return length;
	}
	
	public static long nextNumber(long n) {
		long x;
		if (n % 2 == 0) {
			x = n / 2;
		} else {
			x = 3 * n + 1;
		}
		return x;
	}

}