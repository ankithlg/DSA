class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        int n = graph.length;

        int[] arr = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int neig : graph[i]) {
                list.get(neig).add(i); // Reverse edge: neig -> i
                arr[i]++; // Count original indegree
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int a = q.poll();
            ans.add(a);

            for (int neig : list.get(a)) {
                arr[neig]--;
                if (arr[neig] == 0) {
                    q.add(neig);
                }
            }

        }
        Collections.sort(ans);
        return ans;
    }
}