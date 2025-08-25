class Pair {
    int s;
    int e;

    Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.e, b.e));

        int c = 0;
        int free = -1;

        for (int i = 0; i < end.length; i++) {
            q.add(new Pair(start[i], end[i]));
        }

        while (!q.isEmpty()) {
            Pair a = q.poll();
            int st = a.s;
            int en = a.e;

            if (st > free) {
                c++;
                free = en;
            }
        }
        return c;

    }
}
