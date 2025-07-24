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

    public int countNodes(TreeNode root) {
    
    if(root==null) return 0;

    int l=funl(root);
    int r=funr(root);

    if(l==r)return (int)Math.pow(2,l)-1;

    return 1+countNodes(root.left)+countNodes(root.right);
    }

    public int funl(TreeNode root){
      int h=0;

      while(root!=null){
        h=h+1;
        root=root.left;
      }
      return h;

    }
      public int funr(TreeNode root){
      int h=0;

      while(root!=null){
        h++;
        root=root.right;
      }
      return h;

    }
}