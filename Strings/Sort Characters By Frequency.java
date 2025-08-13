class Pair {
    char c;
    int val;

    Pair(char c, int val) {
        this.c = c;
        this.val = val;
    }
}

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        String str = "";

        for (char num : s.toCharArray()) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.val - a.val);

        for (char num : map.keySet()) {
            int v = map.get(num);
            q.add(new Pair(num, v));
        }

        while (!q.isEmpty()) {
            Pair a = q.poll();
            char ch = a.c;
            int val = a.val;

            for (int i = 0; i < val; i++) {
                str += ch;
            }
        }
        return str;

    }
}