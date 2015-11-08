import java.io.File;
import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System. in );

        while (true) {

            int M = in .nextInt();
            int N = in .nextInt();
            if ((M | N) == 0) break;
            Team[] teamCap = new Team[M];
            int[] tablesCap = new int[N + 1];
            int[] teamMember = new int[M];
            for (int i = 0; i < M; i++) {
                int capTe = in .nextInt();
                teamCap[i] = new Team(i, capTe);
                teamMember[i] = capTe;
            }

            // sorting team descendingly according to their number of members
            Arrays.sort(teamCap);
            boolean[][] seatOrder = new boolean[M + 1][N + 1];

            for (int i = 0; i < N; i++)
            tablesCap[i] = in .nextInt();

            // Greedy way to match team members to tables
            for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                int cap = teamCap[i].getCap();
                int id = teamCap[i].getId();
                if (cap > 0 && tablesCap[j] > 0 && seatOrder[id][j] == false) {
                    seatOrder[id][j] = true;
                    teamCap[i].setCap(--cap);
                    tablesCap[j]--;
                }
            }

            // check whether any member of a team is left alone
            int memberAfterDivision = 0;
            for (int i = 0; i < M; i++)
            memberAfterDivision += teamCap[i].getCap();

            // no solution if any member is left alone
            if (memberAfterDivision > 0) System.out.println("0");

            // otherwise , print solution
            else {
                System.out.println("1");
                for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++) {

                    if (seatOrder[i][j] && teamMember[i] > 1) {
                        System.out.print((j + 1) + " ");
                        teamMember[i]--;
                    } else if (seatOrder[i][j] && teamMember[i] == 1) {
                        System.out.println((j + 1));
                        teamMember[i]--;
                    }
                }
            }
        }
    }
}

class Team implements Comparable {

    private int id;
    private int cap;

    public Team(Integer id, Integer cap) {
        this.id = id;
        this.cap = cap;
    }

    int getId() {

        return id;
    }

    int getCap() {

        return cap;
    }

    public void setCap(int cap) {

        this.cap = cap;

    }

    public int compareTo(Object o) {

        Team t = (Team) o;
        return t.cap - this.cap;
    }
}