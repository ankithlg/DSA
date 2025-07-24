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

    public TreeNode bstFromPreorder(int[] preorder) {
    int[] A=new int[1];
    A[0]=0;
     return find(preorder,Long.MAX_VALUE,A);
     }   
     public TreeNode find(int[] preorder,long max,int[] A){
     if(A[0]==preorder.length || preorder[A[0]]>max)return null;
     TreeNode root=new TreeNode(preorder[A[0]++]);

    root.left=find(preorder,root.val,A);
    root.right=find(preorder,max,A);
      
      return root;
      }



     }
    
