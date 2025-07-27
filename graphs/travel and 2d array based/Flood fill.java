class Pair{
  int row;
  int col;
  Pair(int row,int col){
    this.row=row;
    this.col=col;
  }
}


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int n=image.length;
    int m=image[0].length;
    int[][] dp =new int[n][m];

    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        dp[i][j]=image[i][j];
      }
    }

    int val=image[sr][sc];
   
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(sr,sc));
    dp[sr][sc]=color;


    int[] r={-1,0,1,0};
    int[] c={0,1,0,-1};  

    while(!q.isEmpty()){
            Pair p = q.poll();
            int r1 = p.row;
            int c1 = p.col;
      
      for(int i=0;i<4;i++){
      int r2=r1+r[i];
      int c2=c1+c[i];
      
     if(r2>=0 && r2<n && c2>=0 && c2<m && image[r2][c2]==val && dp[r2][c2]!=color){
      q.add(new Pair(r2,c2));
      dp[r2][c2]=color;
     }

      }
    }


 return dp;
    }
}
