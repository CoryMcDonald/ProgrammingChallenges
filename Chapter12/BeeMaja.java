import java.io.File;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p, d, h;
        int x = 0, y= 0;
        int n;

        while (sc.hasNext()) {
            n = sc.nextInt();
            p = (int) Math.sqrt((n - 1) / 3);
            if ((p + 1) * p * 3 < (n - 1)) {
                p++;
            }
            int dif = n - 1 - p * (p - 1) * 3;
            if (p == 0) {
                d = 0;
                h = 0;
            } else {
                d = (dif / p) % 6;
                h = dif % p;
            }
            switch (d) {
                case 0:
                    x = p - h;
                    y = h;
                    break;
                case 1:
                    x = -h;
                    y = p;
                    break;
                case 2:
                    x = -p;
                    y = p - h;
                    break;
                case 3:
                    x = h - p;
                    y = -h;
                    break;
                case 4:
                    x = h;
                    y = -p;
                    break;
                case 5:
                    x = p;
                    y = h - p;
                    break;
                default:
                    break;
            }
            System.out.println(x + " " + y);
        }
    }
}