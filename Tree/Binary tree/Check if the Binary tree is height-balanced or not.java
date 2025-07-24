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
    public boolean isBalanced(TreeNode root) {


return fun(root)!=-1;



    }
public int fun(TreeNode root){
  if(root==null)return 0;

  int l=fun(root.left);
  int r=fun(root.right);
  
  if(l==-1 || r==-1)return -1;

  if(Math.abs(l-r)>1)return -1;
  return 1+Math.max(l, r);


}

}