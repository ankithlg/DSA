class Solution {
    public int singleNonDuplicate(int[] nums) {
int res=0;

for(int n:nums){
    res=res^n;
}
return res;
    }
}