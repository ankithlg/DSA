class Solution {
    public boolean isBipartite(int[][] graph) {
    int n=graph.length;  
    int[] dp=new int[n];
    Arrays.fill(dp, -1); 
    int co=1;
    for(int i=0;i<graph.length;i++){
      if(dp[i]==-1){
        if(!dfs(graph,dp,i,co))return false;
        }
    } 
 
return true;
}
public boolean dfs(int[][] graph,int[] dp,int node,int co){
dp[node]=co;

for(int i: graph[node]){
 
  if(dp[i]==-1){
  
  if(!dfs(graph,dp,i,1-co))return false;
  }
  else{
    if(dp[i]==dp[node])return false;
  }
  
}
return true;
}

}