class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ind = -1;
        int c = 0;
        int r = 0;
        int n = s.length();

        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, ind + 1);

            if (map.size() == 3) {
                int min = Collections.min(map.values());
                c += min + 1;
            }
            ind++;
            r++;
        }

        return c;

    }
}