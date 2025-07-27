class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] vis = new int[numCourses];
        int[] path = new int[numCourses];
        Stack<Integer> s = new Stack<>();
        int n = numCourses;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int p = pre[0];
            int c = pre[1];
            list.get(p).add(c);

        }

        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                if (dfs(list, vis, path, s, i))
                    return new int[0];
            }
        }
        int[] ans = new int[n];
        int ind = n - 1;

        while (!s.isEmpty()) {
            ans[ind--] = s.pop();
        }
        return ans;
    }

    public boolean dfs(List<List<Integer>> list, int[] vis, int[] path, Stack<Integer> s, int i) {
        vis[i] = 1;
        path[i] = 1;

        for (int neig : list.get(i)) {
            if (vis[neig] == 0) {
                if (dfs(list, vis, path, s, neig)) {
                    return true;
                }

            } else if (vis[neig] == 1 && path[neig] == 1) {
                return true;
            }
        }

        path[i] = 0;
        s.push(i);
        return false;
    }
}