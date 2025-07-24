
/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Tuple{
  Node node;
  int c;

Tuple(Node node,int c){
    this.node=node;
    this.c=c;
      }
}

class Solution {
   
    static ArrayList<Integer> topView(Node root) {
       
        ArrayList<Integer> list=new  ArrayList<>();
        
        Queue<Tuple> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();

        
     
        
         q.offer(new Tuple(root, 0));
        
        while(!q.isEmpty())
        {
            int n=q.size();
           
            for(int  i=0;i<n;i++){

               Tuple no=q.remove();
               Node N=no.node;
               int col=no.c;

               if(!map.containsKey(col)){
                map.put(col,N.data);
               }
              
            if (N.left != null) q.add(new Tuple(N.left, col - 1));
            if (N.right != null) q.add(new Tuple(N.right, col + 1));
         }
        }
       
       for(int x:map.values()){
        list.add(x);
       }




        return list;
    }
}