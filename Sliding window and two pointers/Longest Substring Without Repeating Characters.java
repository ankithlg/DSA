class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int max = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);

            while (set.contains(c)) {
                char lc = s.charAt(l);
                set.remove(lc);
                l++;
            }
            set.add(c);

            max = Math.max(max, r - l + 1);
        }
        return max;

    }
}