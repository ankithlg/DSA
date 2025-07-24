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
    Map<Integer,Integer> map=new HashMap<>();
    int ind;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    ind=0;

    for(int i=0;i<preorder.length;i++){
      map.put(inorder[i],i);
    }
    return find(preorder,0,preorder.length-1);
    }

    public TreeNode find(int[] preorder,int left, int right){
      if(left>right)return null;

      int v=preorder[ind];
      ind++;
      TreeNode root=new TreeNode(v);
      int index=map.get(v);
       
      root.left=find(preorder,left,index-1);
      root.right=find(preorder,index+1,right);

      return root; 

      


    }
}