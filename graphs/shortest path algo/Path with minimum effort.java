class Pair {
    int d, r, c;

    Pair(int d, int r, int c) {
        this.d = d;
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dis = new int[n][m];

        for (int i = 0; i < n; i++)
            Arrays.fill(dis[i], Integer.MAX_VALUE);

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.d - b.d);

        q.add(new Pair(0, 0, 0));

        int[] row = { -1, 0, 1, 0 };
        int[] col = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {

            Pair p = q.poll();
            int di = p.d;
            int r1 = p.r;
            int c1 = p.c;
            dis[r1][c1] = di;
            if (r1 == n - 1 && c1 == m - 1)
                return di;

            for (int i = 0; i < 4; i++) {
                int r2 = r1 + row[i];
                int c2 = c1 + col[i];

                if (r2 >= 0 && r2 < n && c2 >= 0 && c2 < m) {
                    int max = Math.max(Math.abs(heights[r1][c1] - heights[r2][c2]), di);

                    if (max < dis[r2][c2]) {
                        dis[r2][c2] = max;
                        q.add(new Pair(max, r2, c2));
                    }

                }
            }

        }

        return dis[n - 1][m - 1];

    }
}