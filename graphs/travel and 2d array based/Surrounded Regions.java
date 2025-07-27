package graphs;
class Solution {
    public void solve(char[][] board) {
      int n=board.length;
      int m=board[0].length;
      int[][] dp=new int[n][m];
      for(int i=0;i<n;i++){
        Arrays.fill(dp[i],0);
      }

      int[] row={-1,0,1,0};
      int[] col={0,1,0,-1};
      
      for(int i=0;i<n;i++){
        if(board[i][0]=='O'){
          dfs(board,dp,i,0);
        }
        if(board[i][m-1]=='O'){
          dfs(board,dp,i,m-1);
        }
      }

      for(int i=0;i<m;i++){
        if(board[0][i]=='O'){
          dfs(board,dp,0,i);
        }
        if(board[n-1][i]=='O'){
          dfs(board,dp,n-1,i);
        }

      }
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
          if(dp[i][j]==0){
            board[i][j]='X';
          }
        }
      }


      }
public void dfs(char[][] board,int[][] dp,int r,int c){
  dp[r][c]=1;
  
  int[] row={-1,0,1,0};
  int[] col={0,1,0,-1};

  for(int i=0;i<4;i++){
    int ro=r+row[i];
    int co=c+col[i];

   if(ro>=0 && ro<board.length && co>=0 && co<board[0].length && board[ro][co]=='O' && dp[ro][co]==0){
    dfs(board,dp,ro,co);
    
   }

  }
}
}