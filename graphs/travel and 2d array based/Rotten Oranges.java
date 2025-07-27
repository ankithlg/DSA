class Pair{
  int col;
  int row;
  int t;

  Pair(int row,int col,int t){
    this.row=row;
    this.col=col;
    this.t=t;
  }
}




class Solution {
    public int orangesRotting(int[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
      Queue<Pair> q=new LinkedList<>();
      int[][] dp=new int[n][m];
     int  count=0;
      int time=0;
     int  co=0;
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==2){
                dp[i][j]=2;
                q.add(new Pair(i,j,0));
            }
            else{
                dp[i][j]=0;
            }
            if(grid[i][j]==1){
                count++;
            }
        }
      }

      int[] r={-1,0,1,0};
      int[] c={0,1,0,-1};

      while(!q.isEmpty()){
        int r1=q.peek().row;
        int c1=q.peek().col;
        int ti=q.peek().t;
        time=Math.max(time,ti);
        q.poll();



        for(int i=0;i<4;i++){
            int r2=r1+r[i];
            int c2=c1+c[i];

            if(r2>=0 && r2<n && c2>=0 && c2<m && grid[r2][c2]==1 && dp[r2][c2]==0){
                q.add(new Pair(r2,c2,ti+1));
                dp[r2][c2]=2;
                co++;
            }


        }

      }
      if(count!=co)return -1;
      return time;

    }
}