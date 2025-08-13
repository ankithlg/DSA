class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        int n = strs.length - 1;

        String fir = strs[0];
        String last = strs[n];

        int a = fir.length();
        int b = last.length();

        int i = 0;
        if (a > b) {
            while (i < b) {
                if (fir.charAt(i) == last.charAt(i)) {
                    i++;
                } else {
                    break;
                }
            }
        } else {
            while (i < a) {
                if (fir.charAt(i) == last.charAt(i)) {
                    i++;
                } else {
                    break;
                }
            }

        }
        return i == 0 ? "" : fir.substring(0, i);
    }
}