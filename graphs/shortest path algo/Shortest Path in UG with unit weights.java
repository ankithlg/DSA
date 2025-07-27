class Pair {
    int k;
    int v;

    Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }

}

class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here

        int[] dp = new int[adj.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        dp[src] = 0;

        while (!q.isEmpty()) {

            Pair node = q.poll();
            int key = node.k;
            int dis = node.v;

            for (int num : adj.get(key)) {
                if (dp[num] == Integer.MAX_VALUE) {
                    dp[num] = dis + 1;
                    q.add(new Pair(num, dis + 1));
                }

            }
        }
        for (int i = 0; i < adj.size(); i++) {
            if (dp[i] == Integer.MAX_VALUE)
                dp[i] = -1;
        }
        return dp;

    }
}