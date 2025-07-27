class Solution {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        Stack<Integer> s = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
        }

        int[] dp = new int[V];
        Arrays.fill(dp, 0);

        for (int i = 0; i < V; i++) {
            if (dp[i] == 0) {
                dfs(i, dp, list, s);
            }
        }
        while (!s.isEmpty()) {
            ans.add(s.pop());
        }
        return ans;

    }

    public static void dfs(int i, int[] dp, List<List<Integer>> list, Stack<Integer> s) {
        dp[i] = 1;

        for (int num : list.get(i)) {
            if (dp[num] == 0) {
                dfs(num, dp, list, s);
            }
        }
        s.push(i);
    }
}