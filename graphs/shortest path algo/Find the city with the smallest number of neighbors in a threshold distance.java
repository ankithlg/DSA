class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            cost[u][v] = weight;
            cost[v][u] = weight;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][k] != Integer.MAX_VALUE && cost[k][j] != Integer.MAX_VALUE &&
                            cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
        int max = Integer.MAX_VALUE;
        int count = -1;

        for (int i = 0; i < n; i++) {
            int reach = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && cost[i][j] <= distanceThreshold) {
                    reach++;
                }
            }
            if (max >= reach) {
                max = reach;
                count = i;
            }
        }

        return count;
    }
}