class Solution {
    public String reverseWords(String s) {

        String ans = "";
        int n = s.length();

        int i = 0;
        while (i < n) {

            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            if (i >= n)
                break;

            int j = i;

            while (j < n && s.charAt(j) != ' ') {
                j++;
            }
            String a = s.substring(i, j);

            ans = a + (ans.isEmpty() ? "" : " " + ans);
            i = j + 1;

        }
        return ans;
    }
}