class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while (s <= e) {
            int m = (s + e) / 2;

            if (arr[m] < x) {
                s = m + 1;
            } else {
                ans = m;
                e = m - 1;
            }
        }
        return ans;

    }
}