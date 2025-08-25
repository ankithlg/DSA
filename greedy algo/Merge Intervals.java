class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] cur = intervals[0];

        for (int i = 1; i < n; i++) {

            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);

            } else {
                list.add(cur);
                cur = intervals[i];
            }
        }
        list.add(cur);

        return list.toArray(new int[list.size()][2]);

    }
}