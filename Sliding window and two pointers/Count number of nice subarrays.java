
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        return find(nums, k) - find(nums, k - 1);

    }

    public int find(int[] nums, int k) {
        if (k < 0)
            return 0;
        int sum = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        int c = 0;

        while (r < n) {
            sum += nums[r] % 2;

            while (sum > k) {
                sum -= nums[l];
                l++;
            }

            c += (r - l + 1);
            r++;
        }
        return c;
    }
}