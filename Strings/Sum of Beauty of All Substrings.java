class Solution {
    public int beautySum(String s) {

        int ans = 0;

        // for(int i=0;i<s.length()-1;i++){

        // Map<Character,Integer> map=new HashMap<>();
        // map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        // for(int j=i+1;j<s.length();j++){
        // map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
        // int min=Collections.min(map.values());
        // int max=Collections.max(map.values());
        // ans+=(max-min);

        // }
        // }
        // return ans;

        for (int i = 0; i < s.length(); i++) {

            int[] arr = new int[26];

            for (int j = i; j < s.length(); j++) {

                arr[s.charAt(j) - 'a']++;

                int max = 0, min = Integer.MAX_VALUE;

                for (int f : arr) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }
                ans += (max - min);

            }
        }

        return ans;

    }
}