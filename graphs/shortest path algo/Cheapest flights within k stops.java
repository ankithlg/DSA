import java.util.*;

class Pair {
    int city, cost, stops;

    Pair(int city, int cost, int stops) {
        this.city = city;
        this.cost = cost;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            adj.get(from).add(new int[]{to, price});
        }

        // Min-heap by price
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(src, 0, 0));

        // 2D distance array to track [city][stops]
        int[][] dist = new int[n][k + 2]; // stops go from 0 to k+1
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int city = cur.city;
            int cost = cur.cost;
            int stops = cur.stops;

            // ✅ If destination reached within allowed stops
            if (city == dst) return cost;

            if (stops > k) continue; // ✅ We can only do at most k stops

            for (int[] nei : adj.get(city)) {
                int nextCity = nei[0], price = nei[1];
                int newCost = cost + price;

                // ✅ If this path to nextCity with (stops+1) is cheaper
                if (newCost < dist[nextCity][stops + 1]) {
                    dist[nextCity][stops + 1] = newCost;
                    pq.add(new Pair(nextCity, newCost, stops + 1));
                }
            }
        }

        return -1; // No valid path found
    }
}
