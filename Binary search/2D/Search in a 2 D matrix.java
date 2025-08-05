class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return bs(matrix[i], target);
            }
        }

        return false;
    }

    public boolean bs(int[] nums, int x) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (nums[mid] == x)
                return true;
            else if (nums[mid] < x)
                s = mid + 1;
            else {
                e = mid - 1;
            }
        }
        return false;
    }
}
