class Solution {
    public int maxDepth(String s) {
        int c = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                c++;
            }
            max = Math.max(max, c);

            if (ch == ')') {
                c--;
            }

        }
        return max;

    }
}