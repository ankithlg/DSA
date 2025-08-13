class Solution {
    public boolean rotateString(String s, String goal) {

        // StringBuilder sb=new StringBuilder(s);

        // if(s.length()!=goal.length())return false;

        // int i=0;
        // while(i<s.length()){
        // char c=sb.charAt(0);
        // sb.deleteCharAt(0);
        // sb.insert(s.length()-1,c);
        // if(sb.toString().equals(goal))return true;
        // i++;
        // }

        // return false;
        return s.length() == goal.length() && (s + s).contains(goal);

    }
}