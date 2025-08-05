class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l = low(nums, target);
        int u = up(nums, target);

        if (l == -1 || u == -1)
            return new int[] { -1, -1 };
        if (nums[l] != target && nums[u] != target)
            return new int[] { -1, -1 };
        return new int[] { u, l };
    }

    public int low(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int f = -1;

        while (s <= e) {
            int m = (s + e) / 2;

            if (nums[m] <= target) {
                f = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return f;
    }

    public int up(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int c = -1;

        while (s <= e) {
            int m = (s + e) / 2;

            if (nums[m] < target) {
                s = m + 1;
            } else {
                c = m;
                e = m - 1;
            }
        }
        return c;
    }

}