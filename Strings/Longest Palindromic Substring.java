class Solution {
    public String longestPalindrome(String s) {

        String max = "";

        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, h = i + 1;

            while (l >= 0 && h < s.length()) {
                if (s.charAt(l) != s.charAt(h)) {
                    break;
                }
                if ((h - l + 1) > max.length()) {
                    max = s.substring(l, h + 1);
                }
                l--;
                h++;
            }

            int le = i, r = i + 1;
            while (le >= 0 && r < s.length()) {
                if (s.charAt(le) != s.charAt(r))
                    break;
                if ((r - le + 1) > max.length()) {
                    max = s.substring(le, r + 1);
                }

                le--;
                r++;
            }

        }
        return max.isEmpty() ? s.substring(0, 1) : max;
    }
}