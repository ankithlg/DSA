class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int n = V;
        int[] dp = new int[n];
        Queue<Integer> q = new LinkedList<>();

        List<List<Integer>> adj = new ArrayList<>();

        Arrays.fill(dp, 0);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

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
            int p = q.poll();
            c++;
            for (int num : adj.get(p)) {
                dp[num]--;
                if (dp[num] == 0) {
                    q.add(num);
                }
            }

        }

        return c != V;
    }
}