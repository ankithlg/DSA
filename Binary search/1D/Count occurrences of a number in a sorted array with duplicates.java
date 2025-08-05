class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int l = low(arr, target);
        int u = up(arr, target);

        if (l == -1 || u == -1)
            return 0;
        if (arr[l] != target && arr[u] != target)
            return 0;
        return l - u + 1;
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
