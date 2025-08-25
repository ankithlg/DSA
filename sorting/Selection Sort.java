class Solution {
    void selectionSort(int[] arr) {
        // code here

        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i; j < arr.length; j++) {

                if (arr[min] > arr[j]) {
                    min = j;
                }

            }

            if (min != i) { // necessary because im using xor;
                arr[min] = arr[min] ^ arr[i];
                arr[i] = arr[min] ^ arr[i];
                arr[min] = arr[min] ^ arr[i];

            }
        }

    }
}