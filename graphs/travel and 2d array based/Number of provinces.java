class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int n=isConnected.length;
        int[] arr =new int[n];


        for(int i=0;i<n;i++){
          if(arr[i]!=1){
          count++;
          find(isConnected,arr,i);
          }
       
        }
           return count;
    }
      public void find(int[][] isConnected,int[] arr,int i){
          arr[i]=1;

          for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && arr[j]!=1){
             find(isConnected,arr,j);  
            }
          }
        }


}