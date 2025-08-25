// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int max = 0;
        int n = dep.length;
        int c = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                c++;
                max = Math.max(max, c);
                i++;
            } else {
                c--;
                j++;
            }

        }
        return max;
    }
}
