class Solution {
    public int nthRoot(int n, int m) {
        // code here

        int s = 1;
        int e = m;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            long sq = 1;

            for (int i = 1; i <= n; i++) {
                sq *= mid;
            }

            if (sq == m)
                return mid;

            else if (sq < m) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}