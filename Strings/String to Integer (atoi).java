class Solution {
    public int myAtoi(String s) {

        int i = 0;
        Boolean tag = true;
        String str = "";

        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        if (i < s.length() && s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') {
                tag = false;
                i++;
            }
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            str += s.charAt(i);
            i++;
        }

        if (str.isEmpty())
            return 0;

        int num = Integer.parseInt(str);

        try {
            return tag == true ? num : -num;
        } catch (NumberFormatException e) {
            return tag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

    }
}