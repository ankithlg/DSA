// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] j : edges) {
                int u = j[0];
                int v = j[1];
                int val = j[2];

                if (dis[u] != Integer.MAX_VALUE && dis[u] + val < dis[v]) {
                    dis[v] = dis[u] + val;
                }
            }

        }

        for (int[] j : edges) {
            int u = j[0];
            int v = j[1];
            int val = j[2];

            if (dis[u] != Integer.MAX_VALUE && dis[u] + val < dis[v]) {
                return new int[] { -1 };
            }
        }
        for (int i = 0; i < V; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = (int) Math.pow(10, 8);
            }
        }

        return dis;
    }
}