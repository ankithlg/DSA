class Pair {
    int node, dis;

    Pair(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {

        List<List<Pair>> l = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            l.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            l.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dis - b.dis);

        q.add(new Pair(src, 0));

        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int n = p.node;
            int d = p.dis;

            for (Pair i : l.get(n)) {
                if (ans[i.node] > d + i.dis) {
                    ans[i.node] = d + i.dis;
                    q.add(new Pair(i.node, ans[i.node]));
                }
            }
        }
        return ans;

    }
}