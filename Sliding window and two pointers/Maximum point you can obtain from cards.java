class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int ls = sum;
        max = sum;
        int rs = 0;
        int p = k - 1;

        for (int i = n - 1; i >= (n - k); i--) {
            ls -= cardPoints[p--];
            rs += cardPoints[i];

            max = Math.max(max, ls + rs);

        }
        return max;
    }
}