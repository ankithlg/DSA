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
    public List<Integer> preorderTraversal(TreeNode root) {
 //1st method recursion   
// preorder(root);


// return list;
//     }

//     public void preorder(TreeNode node){

//         if(node==null){
//             return;
//         }
//       list.add(node.val);
//        preorder(node.left);
//        preorder(node.right);

//     }


//2nd methode(iteration)

if(root==null) return list;

Stack<TreeNode> s=new Stack<>();

s.push(root);
while(!s.isEmpty()){
  TreeNode node=s.pop();
  list.add(node.val);
  if(node.right!=null)s.add(node.right);
  if(node.left!=null)s.add(node.left);
}
return list;



    }
}