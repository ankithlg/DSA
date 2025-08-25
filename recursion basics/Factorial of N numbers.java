class Solution {
    public void reverseArray(int arr[]) {
        // code here
        fun(0, arr.length - 1, arr);

    }

    public void fun(int l, int r, int[] arr) {

        if (l >= r) {
            return;
        }

        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;

        fun(l + 1, r - 1, arr);

    }
}