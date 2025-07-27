class Solution {
    
    
    
    
    ArrayList<Integer> list=new ArrayList<>();

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

    int[] arr=new int[adj.size()];
    Arrays.fill(arr,0);
    find(adj,arr,0);
    return list;
     }
    public void find(ArrayList<ArrayList<Integer>> adj,int[] arr,int a){
               
        if(arr[a]==0){
        arr[a]=1;
        list.add(a);
        for(int i:adj.get(a)){
        find(adj,arr,i);
        } 
        }
    }
}