class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int m = a.length;
        int i = 0;
        int n = b.length;
        int j = 0;
        int ans = 0;

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                ans++;
                if (ans == k)
                    return a[i];
                i++;
            } else {
                ans++;
                if (ans == k)
                    return b[j];
                j++;
            }
        }

        while (i < m) {
            ans++;
            if (ans == k)
                return a[i];
            i++;

        }

        while (j < n) {
            ans++;
            if (ans == k)
                return b[j];
            j++;
        }

        return -1;
    }
}