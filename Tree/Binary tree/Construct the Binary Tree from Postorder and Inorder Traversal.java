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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       for(int i=0;i<postorder.length;i++){
        map.put(inorder[i],i);
       }
       ind=postorder.length-1;
       return find(postorder,0,postorder.length-1);
}
public TreeNode find(int[] postorder,int l ,int r)  {
    if(l>r)return null;

    int v=postorder[ind];
    ind--;
    TreeNode root=new TreeNode(v);
    int index=map.get(v);

    root.right=find(postorder,index+1,r);
    root.left=find(postorder,l,index-1);

    return root;

}

}