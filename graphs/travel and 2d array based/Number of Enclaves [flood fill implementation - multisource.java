class Solution {
    public int numEnclaves(int[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
      int[][] dp=new int[n][m];
      int[] row={-1,0,1,0};
      int[] col={0,1,0,-1};

      int cg=0;
      int cdp=0;

    for(int i=0;i<n;i++){
      Arrays.fill(dp[i],0);
    }

    for(int i=0;i<n;i++){
      if(grid[i][0]==1){
        dfs(grid,dp,row,col,i,0);
      }
      if(grid[i][m-1]==1){
        dfs(grid,dp,row,col,i,m-1);
      }
    }
    for(int i=0;i<m;i++){
      if(grid[0][i]==1){
        dfs(grid,dp,row,col,0,i);
      }
      if(grid[n-1][i]==1){
        dfs(grid,dp,row,col,n-1,i);
      }
    }
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(grid[i][j]==1){
          cg++;
        }
        if(dp[i][j]==1){
          cdp++;
        }
      }
    }
return  cg-cdp;
    }
    public void dfs(int[][] grid,int[][] dp,int[] row,int[] col,int r,int c){

      dp[r][c]=1;

      for(int i=0;i<4;i++){
        int r1=r+row[i];
        int c1=c+col[i];

        if(r1>=0 && r1<grid.length && c1>=0 && c1<grid[0].length && dp[r1][c1]==0 && grid[r1][c1]==1){
          dfs(grid,dp,row,col,r1,c1);
        }
      }
     }
    }
