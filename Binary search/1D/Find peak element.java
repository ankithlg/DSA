class Solution {
    public int findPeakElement(int[] nums) {

        // int min=Integer.MIN_VALUE;
        // int ind=0;

        // for(int i=0;i<nums.length;i++){
        // if(nums[i]>=min){
        // min=nums[i];
        // ind=i;
        // continue;
        // }
        // break;
        // }
        // return ind;

        int s = 1;
        int e = nums.length - 2;

        if (nums.length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        while (s <= e) {

            int mid = (s + e) / 2;

            if (nums[mid - 1] > nums[mid]) {
                e = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }
}
