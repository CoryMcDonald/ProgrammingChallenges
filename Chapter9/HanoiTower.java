import java.io.File;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int availablePegs;
        int numTestCases = Integer.parseInt(scan.nextLine());
        int[] hanoi = new int[51];

        hanoi[0] = -1;
        for (int i = 1; i <= 50; i += 2) {
            hanoi[i] = hanoi[i - 1] + i + 1;
            hanoi[i + 1] = hanoi[i] + i + 1;
        }

        while (numTestCases-- > 0) {
            availablePegs = Integer.parseInt(scan.nextLine());

            System.out.println(hanoi[availablePegs]);
        }
    }
}