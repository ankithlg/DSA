// User function Template for Java

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        // code here

        Queue<Integer> q = new LinkedList<>();

        Set<Integer> s = new HashSet<>();

        int f = 0;

        for (int i = 0; i < N; i++) {

            int p = pages[i];

            if (!s.contains(p)) {

                f++;

                if (q.size() == C) {
                    int lru = q.poll();
                    s.remove(lru);
                }

                q.add(p);
                s.add(p);
            } else {
                q.remove(p);
                q.add(p);
            }
        }

        return f;

    }
}