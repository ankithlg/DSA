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
  List<Integer> list=new ArrayList<>();
  int i=0;
    public void recoverTree(TreeNode root) {
       preorder(root); 
       Collections.sort(list);
       ch(root);
    }
    public void preorder(TreeNode root){
      if(root==null)return;
      preorder(root.left);
      list.add(root.val);
      preorder(root.right);
    }
    public void ch(TreeNode root){
      if(root==null)return ;

      ch(root.left);
      if(list.get(i)!=root.val)root.val=list.get(i);
      i++;
      ch(root.right);
      }
}