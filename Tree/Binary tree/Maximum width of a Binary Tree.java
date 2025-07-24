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

 class Tuple{
  TreeNode node;
  int val;
  Tuple(TreeNode node,int val){
    this.node=node;
    this.val=val;
  }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> q=new LinkedList<>();
        
        int max=0;

        q.add(new Tuple(root,0));

        while(!q.isEmpty()){
          int n=q.size();
          int first=0;
          int last=0;
          Tuple p=q.peek();
          int ind=p.val;

          for(int i=0;i<n;i++){
            Tuple N=q.remove();
            TreeNode no=N.node;
            int v=N.val-ind;

            if(i==0)first=v;
            if(i+1==n)last=v;

            if(no.left!=null)q.add(new Tuple(no.left,2*v+1));
            if(no.right!=null)q.add(new Tuple(no.right,2*v+2));

       
          }
          max=Math.max(max,last-first+1);
        }
return max;
    }
}