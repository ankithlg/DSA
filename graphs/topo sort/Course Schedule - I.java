class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] dp = new int[n];
        Queue<Integer> q = new LinkedList<>();

        List<List<Integer>> adj = new ArrayList<>();
        if (n == 1 || n == 0)
            return true;

        Arrays.fill(dp, 0);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
            dp[v]++;
        }

        int c = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int p = q.remove();
            c++;
            for (int num : adj.get(p)) {
                dp[num]--;
                if (dp[num] == 0) {
                    q.add(num);
                }
            }

        }

        return c == n ? true : false;
    }
}