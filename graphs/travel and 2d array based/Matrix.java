package graphs;
class Pair {
    int row, col, d;

    Pair(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.d = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] dp = new int[n][m];
        int[][] ans = new int[n][m];

        // Initialize queue with all 0s and mark as visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    dp[i][j] = 1;
                    ans[i][j] = 0;
                }
            }
        }

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};

        // BFS
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int dis = cur.d;

            for (int i = 0; i < 4; i++) {
                int r2 = row + r[i];
                int c2 = col + c[i];

                if (r2 >= 0 && r2 < n && c2 >= 0 && c2 < m && dp[r2][c2] == 0) {
                    q.add(new Pair(r2, c2, dis + 1));
                    dp[r2][c2] = 1;
                    ans[r2][c2] = dis + 1;
                }
            }
        }

        return ans;
    }
}
