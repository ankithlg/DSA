// User function Template for Java
class Pair {
    int e;
    int val;

    Pair(int e, int val) {
        this.e = e;
        this.val = val;
    }

}

class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> l = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {

            l.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        int[] ans = new int[V];
        int[] dp = new int[V];
        Arrays.fill(dp, 0);
        Arrays.fill(ans, Integer.MAX_VALUE);

        Stack<Integer> q = new Stack<>();

        q.add(0);
        dp[0] = 0;
        ans[0] = 0;
        for (int i = 0; i < V; i++) {
            if (dp[i] == 0) {
                dfs(l, dp, i, q);
            }
        }
        while (!q.isEmpty()) {
            int a = q.pop();

            if (ans[a] != Integer.MAX_VALUE) {
                for (Pair p : l.get(a)) {
                    if (ans[p.e] > p.val + ans[a]) {
                        ans[p.e] = p.val + ans[a];
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    public void dfs(List<List<Pair>> l, int[] dp, int i, Stack<Integer> s) {
        dp[i] = 1;

        for (Pair p : l.get(i)) {
            if (dp[p.e] == 0) {
                dfs(l, dp, p.e, s);

            }

        }
        s.push(i);
    }

}