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
    int row,col;

    Tuple(TreeNode node,int col,int row){
        this.node=node;
        this.col=col;
        this.row=row;
        
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
Queue<Tuple> q=new LinkedList<>();
TreeMap<Integer,List<int[]>> map=new TreeMap<>();
List<List<Integer>>  list=new ArrayList<>();
q.add(new Tuple(root,0,0));

while(!q.isEmpty()){
  int size=q.size();

for(int i=0;i<size;i++){
  Tuple N=q.remove();
  TreeNode n=N.node;
  int c=N.col;
  int r=N.row;

  map.putIfAbsent(c,new ArrayList<>());
  map.get(c).add(new int[]{r,n.val});

  if(n.left!=null)q.add(new Tuple(n.left,c-1,r+1));
  if(n.right!=null)q.add(new Tuple(n.right,c+1,r+1));

}
}
for(List<int[]> x:map.values()){
  Collections.sort(x,(a,b)->{
 if(a[0]==b[0])return a[1]-b[1];
 return a[0]-b[0];
  });
List<Integer> ans=new ArrayList<>();
  for(int[] v:x){
    
    ans.add(v[1]);
  }
  list.add(ans);
}


return list;
    }
}