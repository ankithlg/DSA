class Solution {
    int lowerBound(int[] arr, int target) {

        int ans = -1;
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {

            int m = (s + e) / 2;

            if (arr[m] < target) {
                s = m + 1;
            } else {
                ans = m;
                e = m - 1;
            }
        }
        return ans == -1 ? arr.length : ans;
    }
}
