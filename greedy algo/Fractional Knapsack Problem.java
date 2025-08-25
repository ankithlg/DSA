
class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            list.add(new int[] { values[i], weights[i] });
        }

        list.sort((a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));

        double ans = 0;
        for (int[] a : list) {
            if (a[1] <= W) {
                ans += a[0];
                W -= a[1];
            } else {
                ans += ((double) a[0] / a[1]) * W;
                break;

            }
        }

        return ans;

    }
}