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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<List<Integer>> list=new ArrayList<List<Integer>>();

       if(root==null)return list;

        s.push(root);
        int c=1;
        while(!s.isEmpty()){
          int n=s.size();
          List<Integer> l=new ArrayList<>();
          Stack<TreeNode> st=new Stack<>();
          for(int i=0;i<n;i++){

            TreeNode node=s.pop();
            l.add(node.val);

            if(c%2==0){
              if(node.right!=null)st.add(node.right);
              if(node.left!=null)st.add(node.left);
              }

            else{
              if(node.left!=null)st.add(node.left);
              if(node.right!=null)st.add(node.right);
              }

          }
            c++;
            s=st;
            list.add(l);

        }

     
return list;
    }
}