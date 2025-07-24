/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   HashSet<Integer> set=new HashSet<>();
    ArrayList<Integer> list=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
     fun(root);
     if(set.size()==1)return false;
     for(int num :set){
      
      int val=k-num;
     
      if(val!=num && set.contains(val))return true;
     }
     return false;
}   
public void fun(TreeNode root){
  if(root==null)return ;

  fun(root.left);
  set.add(root.val);
  fun(root.right);

}
}