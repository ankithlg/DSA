class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;

        for (int num : piles) {
            max = Math.max(num, max);
        }

        int s = 1;
        int e = max;
        int ans = max;

        while (s <= e) {

            int mid = s + (e - s) / 2;
            long t = 0;

            for (int num : piles) {
                t += (num + mid - 1) / mid;
            }
            if (t <= h) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }

        return ans;
    }
}