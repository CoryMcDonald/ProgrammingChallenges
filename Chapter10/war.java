import java.util.*;
import java.*;

class Main {
    static int[] P = new int[20000];

    public static void main(String[] args) {
        Arrays.fill(P, -1);
        int n, c, x, y;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        while (true) 
        {
            c = scan.nextInt();
            x = scan.nextInt();
            y = scan.nextInt();
            if((c | x | y) == 0){
                break;
            }

            if (c == 1) {
                if (findset(x) == findset(enemy(y))) {
                    System.out.println(-1);
                    continue;
                }
                unionset(x, y);
                unionset(enemy(x), enemy(y));
            } else if (c == 2) {
                if (findset(x) == findset(y)) {
                    System.out.println(-1);
                    continue;
                }
                unionset(x, enemy(y));
                unionset(enemy(x), y);
            } else if (c == 3) {
                print(findset(x) == findset(y));
            } else if (c == 4) {
                print(findset(x) == findset(enemy(y)));
            }
        }
    }
    
    static int enemy(int v) {
        return v + 10000;
    }
    static int findset(int v) {
        if (P[v] != -1 && P[v] != v) return P[v] = findset(P[v]);
        return v;
    }
    static void unionset(int x, int y) {
        int a = findset(x), b = findset(y);

        if (a < b)
        {
            int t = a;
            a = b;
            b = t;
        }
        P[b] = a;
    }
    static void print(boolean val)
    {        
        System.out.println((val) ? 1 : 0);
    }
    
}