class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (s <= e) {

            int m = (s + e) / 2;

            if (nums[s] <= nums[m]) {
                if (nums[s] < min) {
                    min = nums[s];
                }
                s = m + 1;
            } else {
                min = nums[m];
                e = m - 1;
            }
        }
        return min;

    }
}