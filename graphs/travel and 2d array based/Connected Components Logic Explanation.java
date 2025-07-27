class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> list =new ArrayList<>();
        
        q.add(0);
        int[] dp =new int[adj.size()];
        Arrays.fill(dp,0);
        dp[0]=1;
        while(!q.isEmpty()){
            int val= q.remove();
            list.add(val);
                for(int num:adj.get(val)){
                    
                    if(dp[num]==0){
                    dp[num]=1;
                    q.add(num);
                }
            }
        
        }
        return list;
    }
}