
import java.io.File;
import java.util.Scanner;

public class TouristGuide {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scenario = 0;
        while (sc.hasNext()) {
            scenario++;
            int n = sc.nextInt();
            int r = sc.nextInt();
            if (n == 0 && r == 0) return;

            int[][] table = new int[105][105];
            
            for (int i = 0; i < r; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int weight = sc.nextInt();
                 table[a][b] = table[b][a] = Math.max(table[a][b], weight);
            }
            for (int k = 1; k <= n; k++)
                for (int i = 1; i <= n; i++)
                    for (int j = 1; j <= n; j++)
                        table[i][j] = Math.max(table[i][j], Math.min(table[i][k], table[k][j]));    

            int start = sc.nextInt();
            int end = sc.nextInt();
            int numPeople = sc.nextInt();
            int solution = (int)Math.ceil((double)numPeople / (table[start][end] - 1));
            System.out.println("Scenario #" + scenario);
            System.out.println("Minimum Number of Trips = " + solution);
            System.out.println(); 
        }
    }
}