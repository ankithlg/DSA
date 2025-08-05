class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while (s <= e) {

            int m = (s + e) / 2;

            if (arr[m] <= x) {
                ans = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans;
    }
}
