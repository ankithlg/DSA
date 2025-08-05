class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int s = 0;
        int e = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int ind = -1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (arr[s] <= arr[mid]) {
                if (arr[s] < min) {
                    min = arr[s];
                    ind = s;
                }
                s = mid + 1;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    ind = mid;
                }
                e = mid - 1;
            }
        }
        return ind;
    }
}