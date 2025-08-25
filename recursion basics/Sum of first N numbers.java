class Solution {
    public static int findSum(int n) {

        int ans = fun(n);
        return ans;

    }

    public static int fun(int n) {
        if (n < 1)
            return 0;

        return n + fun(n - 1);

    }
}
