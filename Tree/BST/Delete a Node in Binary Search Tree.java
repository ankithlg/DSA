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

public TreeNode deleteNode(TreeNode root, int key) {
if(root==null)return null;

if(root.val==key)return find(root);
TreeNode t=root;
while(root!=null){
  if(root.val<key){
    if(root.right!=null && root.right.val==key){
      root.right= find(root.right);
      break;
    }
    else{
      root=root.right;
    }
  }
  else{
      if(root.left!=null && root.left.val==key){
      root.left= find(root.left);
      break;
    }
    else{
      root=root.left;
    }

  }

}
return t;
}
public TreeNode find(TreeNode root){
  if(root.right==null)return root.left;
   else if(root.left==null)return root.right;
   else{
    TreeNode r=root.right;
    TreeNode lr=f(root.left);
    lr.right=r;
    return root.left;
   }

}
public TreeNode f(TreeNode root){
  while(root.right!=null)root=root.right;
  return root;
}

    
}