class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((m * k) > n)
            return -1;
        int max = Integer.MIN_VALUE;

        for (int num : bloomDay) {
            max = Math.max(max, num);
        }

        int s = 1;
        int e = max;
        int ans = max;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int b = 0;
            int c = 0;

            for (int i = 0; i < n; i++) {
                if (bloomDay[i] <= mid) {
                    c++;
                    if (c == k) {
                        b++;
                        c = 0;
                    }
                } else {
                    c = 0;
                }

            }

            if (b >= m) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }
        return ans;

    }
}