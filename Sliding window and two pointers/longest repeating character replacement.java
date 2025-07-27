class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int l = 0;

        int mf = 0;

        int r = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        while (r < n) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            mf = Collections.max(map.values());

            while ((r - l + 1) - mf > k) {
                char lc = s.charAt(l);
                map.put(lc, map.get(lc) - 1);
                l++;
            }

            max = Math.max(r - l + 1, max);
            r++;

        }
        return max;
    }
}