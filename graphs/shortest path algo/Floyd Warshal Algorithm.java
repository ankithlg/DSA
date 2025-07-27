// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int m = dist[0].length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Math.pow(10, 8) && dist[k][j] != Math.pow(10, 8)) {
                        int min = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        dist[i][j] = min;
                    }

                }
            }
        }

    }
}