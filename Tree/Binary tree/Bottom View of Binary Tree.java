
/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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
    public ArrayList<Integer> bottomView(Node root) {
        
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

           
                map.put(col,N.data);
               
              
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