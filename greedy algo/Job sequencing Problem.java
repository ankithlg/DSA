class Pair {
    int j, d, p;

    Pair(int j, int d, int p) {
        this.j = j;
        this.d = d;
        this.p = p;
    }
}

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here

        int[] arr = new int[deadline.length + 1];
        Arrays.fill(arr, -1);
        int pro = 0;
        int max = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(b.p, a.p));

        for (int i = 0; i < deadline.length; i++) {
            q.add(new Pair(i, deadline[i], profit[i]));
        }

        for (int i = 0; i < deadline.length; i++) {
            Pair a = q.poll();
            int jo = a.j;
            int d = a.d;
            int p = a.p;

            for (int j = d; j > 0; j--) {
                if (arr[j] == -1) {
                    arr[j] = jo;
                    pro += p;
                    max++;
                    break;

                }
            }

        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(max);
        list.add(pro);

        return list;

    }
}