class Pair {
    int d, n, p;

    Pair(int d, int n, int p) {
        this.d = d;
        this.n = n;
        this.p = p;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.

        int sum = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.d - b.d);
        q.add(new Pair(0, 0, -1));

        int[] dist = new int[V];
        Arrays.fill(dist, 0);

        while (!q.isEmpty()) {
            Pair r = q.poll();
            int dis = r.d;
            int node = r.n;
            int par = r.p;
            if (dist[node] == 1)
                continue;
            dist[node] = 1;
            sum += dis;

            for (int[] num : adj.get(node)) {
                if (dist[num[0]] == 0) {
                    q.add(new Pair(num[1], num[0], par));
                }
            }

        }

        return sum;
    }
}