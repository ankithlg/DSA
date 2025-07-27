class Pair {
    int d, r, c;

    Pair(int d, int r, int c) {
        this.d = d;
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1)
            return -1;

        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 1;

        int[] row = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] col = { 0, 1, 1, 1, 0, -1, -1, -1 };

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int di = p.d;
            int r1 = p.r;
            int c1 = p.c;

            for (int i = 0; i < 8; i++) {
                int r2 = r1 + row[i];
                int c2 = c1 + col[i];

                if (r2 >= 0 && r2 < n && c2 >= 0 && c2 < m && grid[r2][c2] == 0) {
                    if (dis[r2][c2] > di + 1) {
                        dis[r2][c2] = di + 1;
                        q.add(new Pair(di + 1, r2, c2));
                    }
                }
            }
        }

        return dis[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : dis[n - 1][n - 1];
    }
}