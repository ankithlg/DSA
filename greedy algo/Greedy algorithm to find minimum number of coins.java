// User function Template for Java

class Solution {
    static List<Integer> minPartition(int N) {
        // code here

        int[] arr = new int[10];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;
        arr[3] = 10;
        arr[4] = 20;
        arr[5] = 50;
        arr[6] = 100;
        arr[7] = 200;
        arr[8] = 500;
        arr[9] = 2000;

        int i = 9;
        List<Integer> list = new ArrayList<>();

        while (i >= 0) {
            if (N >= arr[i]) {
                N -= arr[i];
                list.add(arr[i]);

            } else {
                i--;
            }
        }
        return list;
    }
}