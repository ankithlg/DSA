class Solution {
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> a = new HashMap<>();
        Map<Character, Character> b = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (a.containsKey(c1) && a.get(c1) != c2)
                return false;
            if (b.containsKey(c2) && b.get(c2) != c1)
                return false;

            a.put(c1, c2);
            b.put(c2, c1);

        }

        return true;
    }
}