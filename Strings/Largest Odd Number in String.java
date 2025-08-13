class Solution {
    public String largestOddNumber(String num) {

        int i = num.length() - 1;

        while (i >= 0) {

            int n = num.charAt(i) - '0';

            if ((n & 1) == 0) {
                i--;

            } else {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}