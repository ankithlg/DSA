class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        return find(nums, goal) - find(nums, goal - 1);

    }

    public int find(int[] nums, int k) {
        if (k < 0)
            return 0;

        int l = 0;
        int r = 0;
        int c = 0;
        int s = 0;

        while (r < nums.length) {
            s += nums[r];

            while (s > k) {
                s -= nums[l];
                l++;
            }

            c += (r - l + 1);
            r++;
        }
        return c;
    }
}