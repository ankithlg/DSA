class Pair {
    long dis;
    int node;

    Pair(long dis, int node) {
        this.dis = dis;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        List<List<Pair>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            list.get(road[0]).add(new Pair(road[2], road[1]));
            list.get(road[1]).add(new Pair(road[2], road[0]));
        }

        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        ways[0] = 1;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis));
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            long d = p.dis;
            int no = p.node;

            for (Pair num : list.get(no)) {

                long cur = num.dis + d;

                if (dist[num.node] == cur)
                    ways[num.node] = (ways[num.node] + ways[no]) % 1_000_000_007;
                else if (dist[num.node] > cur) {
                    dist[num.node] = cur;
                    ways[num.node] = ways[no];
                    q.add(new Pair(dist[num.node], num.node));
                }
            }
        }

        return ways[n - 1];
    }
}
