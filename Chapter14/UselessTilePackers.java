
import java.io.*;
import java.text.*;
import java.util.*;

class Main {

    static final double EPS = 1e-9;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int numCorners = Integer.parseInt(in.nextLine().trim());
        StringTokenizer st;
        StringBuilder report = new StringBuilder();
        int currCase = 1;
        NumberFormat formatter = new DecimalFormat("#0.00");


        while (numCorners != 0) {
            Polygon tile = new Polygon();
            for (int i = 0; i < numCorners; i ++) {
                st = new StringTokenizer(in.nextLine());
                tile.corners.add(new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
            }

            double tileArea = tile.computeArea();
            double packArea = tile.getConvexHull().computeArea();

            report.append("Tile #").append(currCase);
            report.append("\nWasted Space = ").append(formatter.format((packArea - tileArea) / packArea * 100)).append(" %\n\n");

            numCorners = Integer.parseInt(in.nextLine().trim());
            currCase ++;
        }

        System.out.print(report);
    }

    static class Polygon {
        ArrayList<Point> corners = new ArrayList<Point>();
        Point pivot = new Point(0.0, 0.0);

        public double computeArea() {
            double result = 0.0, x1, y1, x2, y2;
            for (int i = 0; i < corners.size() - 1; i ++) {
                x1 = corners.get(i).x; x2 = corners.get(i + 1).x;
                y1 = corners.get(i).y; y2 = corners.get(i + 1).y;
                result += (x1 * y2 - x2 * y1);
            }

            result += (corners.get(corners.size() - 1).x * corners.get(0).y - corners.get(0).x * corners.get(corners.size() - 1).y);

            return Math.abs(result) / 2.0;
        }

        public Polygon getConvexHull() {

            int i, j, n = corners.size();
            if (n <= 3) {
                if (corners.get(0).compareTo(corners.get(n - 1)) != 0)
                    corners.add(corners.get(0));
                return this;
            }

            
            int P0 = 0;
            for (i = 1; i < n; i++) {
                if (corners.get(i).y < corners.get(P0).y
                        || (corners.get(i).y == corners.get(P0).y && corners.get(i).x > corners.get(P0).x))
                    P0 = i;
            }

            
            Point temp = corners.get(0);
            corners.set(0, corners.get(P0));
            corners.set(P0 ,temp);

            
            pivot = corners.get(0);
            Collections.sort(corners, new Comparator<Point>() {
                public int compare(Point a, Point b) {
                    if (pivot.collinear(a, b))
                        return pivot.distTo(a) < pivot.distTo(b) ? -1 : 1;
                    double d1x = a.x - pivot.x, d1y = a.y - pivot.y;
                    double d2x = b.x - pivot.x, d2y = b.y - pivot.y;
                    return (Math.atan2(d1y, d1x) - Math.atan2(d2y, d2x)) < 0 ? -1 : 1;
                }
            });

            
            Polygon hull = new Polygon();
            
            hull.corners.add(corners.get(n - 1));
            hull.corners.add(corners.get(0));
            hull.corners.add(corners.get(1));
            i = 2;
            while (i < n) {
                j = hull.corners.size() - 1;
                if (Point.isCCW(hull.corners.get(j - 1), hull.corners.get(j), corners.get(i)))
                    hull.corners.add(corners.get(i++));
                else
                    hull.corners.remove(hull.corners.size() - 1);
            }

            return hull;
        }
    }

    static class Point implements Comparable<Point>{
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public boolean collinear(Point a, Point b) {
            return Math.abs(Vect.cross(new Vect(this, a), new Vect(this, b))) < EPS;
        }

        public double distTo(Point b) {
            return Math.hypot(x - b.x, y - b.y);
        }

        @Override
        public int compareTo(Point o) {
            if (Math.abs(x - o.x) > EPS)
                return (int)Math.ceil(x - o.x);
            else if (Math.abs(y - o.y) > EPS)
                return (int)Math.ceil(y - o.y);
            else
                return 0;
        }

        static boolean isCCW(Point p, Point q, Point r) {
            return Vect.cross(new Vect(p, q), new Vect(p, r)) > 0;
        }
    }


    static class Vect {
        double x, y;

        public Vect(Point a, Point b) {
            x = b.x - a.x;
            y = b.y - a.y;
        }


        static double cross(Vect a, Vect b) { return a.x * b.y - a.y * b.x; }
    }
}