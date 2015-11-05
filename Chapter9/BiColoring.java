import java.io.File;
import java.util.*;

class Main {
    
    static LinkedList<Integer>[] adjList;

    static boolean isBipartite(int sr) {
        TreeMap<Integer, Integer> distribution = new TreeMap<Integer, Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        distribution.put(sr, 0);
        queue.add(sr);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < adjList[current].size(); i++) {
                int node = adjList[current].get(i);
                if (distribution.containsKey(node)) {
                    if (distribution.get(node) == distribution.get(current))
                        return false;
                } else {
                    distribution.put(node, 1 - distribution.get(current));
                    queue.add(node);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan =new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int numNodes, numLines, node1, node2;
        while ((numNodes = scan.nextInt()) != 0) {
            numLines = scan.nextInt();
            adjList = new LinkedList[numNodes];

            for (int i = 0; i < numNodes; i++) {
                adjList[i] = new LinkedList<Integer>();
            }

            for (int i = 0; i < numLines; i++) {
                node1 = scan.nextInt();
                node2 = scan.nextInt();
                adjList[node1].add(node2);
                adjList[node2].add(node1);
            }

            if (isBipartite(0))
                out.append("BICOLORABLE.\n");
            else
                out.append("NOT BICOLORABLE.\n");
        }
        System.out.print(out);
    }
}