class Pair {
    int d, node;

    Pair(int d, int node) {
        this.d = d;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] tim : times) {
            list.get(tim[0]).add(new Pair(tim[2], tim[1]));
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.d - b.d);
        q.add(new Pair(0, k));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int di = p.d;
            int no = p.node;

            for (Pair num : list.get(no)) {
                if (dis[num.node] > num.d + di) {
                    dis[num.node] = num.d + di;
                    q.add(new Pair(dis[num.node], num.node));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dis[i]);
        }
        return max;
    }
}