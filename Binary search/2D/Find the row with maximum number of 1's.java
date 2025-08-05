class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
        int ans = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int a = bs(arr[i]);

            if (a != -1 && max < (m - a)) {
                max = (m - a);
                ans = i;
            }
        }
        return ans;

    }

    public int bs(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (nums[mid] < 1) {
                s = mid + 1;
            } else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans;

    }
}