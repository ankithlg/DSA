class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }
        int s = 1;
        int e = max;
        int ans = max;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            int t = 0;

            for (int num : nums) {

                t += (num + mid - 1) / mid;
            }

            if (t <= threshold) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }

        return ans;
    }
}