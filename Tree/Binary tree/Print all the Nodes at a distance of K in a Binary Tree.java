/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Tup{
  TreeNode l1;
  int dis;

  Tup(TreeNode l1,int dis){
    this.l1=l1;
   this.dis=dis;
  }
}



class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      Queue<TreeNode> q=new LinkedList<>();
      HashMap<TreeNode,TreeNode> map=new HashMap<>();
       
       if(root==null)return new ArrayList<>(0);


      q.add(root);
      map.put(root,null);

      while(!q.isEmpty()){
        int n=q.size();

        for(int i=0;i<n;i++){
          TreeNode node=q.remove();

          if(node.left!=null){
            q.add(node.left);
            map.put(node.left,node);
        }
            if(node.right!=null){
            q.add(node.right);
            map.put(node.right,node);
        }

      }
}
Queue<Tup> q1=new LinkedList<>();
HashSet<TreeNode> set=new HashSet<>();

q1.add(new Tup(target,0));
set.add(target);
int j=0;

while(j<k){
int n=q1.size();

for(int i=0;i<n;i++){
  Tup node=q1.remove();
  TreeNode no=node.l1;

  TreeNode parent = map.get(no);
  if(parent!=null && !set.contains(map.get(no))){
    q1.add(new Tup(map.get(no),i+1));
    set.add(map.get(no));
  }
  if(no.left!=null && !set.contains(no.left)){
    q1.add(new Tup(no.left,i+1));
    set.add(no.left);
  }
    if(no.right!=null && !set.contains(no.right)){
    q1.add(new Tup(no.right,i+1));
    set.add(no.right);
  }

}
j++;
}
List<Integer> list=new ArrayList<>();

while(!q1.isEmpty()){
  Tup n=q1.remove();
  TreeNode v=n.l1;
  int v1=v.val;
  list.add(v1);
}
return list;
}
}