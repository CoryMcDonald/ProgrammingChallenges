import java.io.File;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long steps = sc.nextLong();
            if (steps == 0)
                return;

            long x, y;
            long border = (long)Math.floor(Math.sqrt(steps)) + 1;
            long dist = steps - (border - 1)*(border - 1);

            if (dist == 0) {
                x = 1;
                y = border - 1;
            } else if (dist <= border) {
                x = dist;
                y = border;
            } else {
                x = border;
                y = 2 * border - dist;
            }

            if (border % 2 == 1) {
                long temp = x;
                x = y;
                y = temp;
            }

            System.out.println(x + " " + y);
        }
    }
}