class Solution {
    public int minPathSum(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        memo[n-1][m-1] = grid[n-1][m-1];
        for(int i = n-2; i>=0; i--){
            memo[i][m-1] = grid[i][m-1]+memo[i+1][m-1];
        }
        for(int j = m-2; j>=0; j--){
            memo[n-1][j] = grid[n-1][j]+memo[n-1][j+1];
        }
    
        for(int i = n-2; i>=0; i--){
            for(int j = m-2; j>=0; j--){
                memo[i][j] = Math.min(memo[i+1][j],memo[i][j+1])+grid[i][j];
            }
        }
        // return minPath(grid,0,0,n,m,memo);
        return memo[0][0];
    }
    
    public int minPath(int grid[][], int r, int c, int n, int m, int[][]memo){
    
        if(r==n-1 && c==m-1) return memo[r][c]=grid[r][c];
        
        if(memo[r][c]!=0) return memo[r][c];
        
        int sa1=(int)(1e8);
        if(r+1<n)
            sa1 = Math.min(minPath(grid,r+1,c,n,m,memo),sa1);
        if(c+1<m)
            sa1 = Math.min(minPath(grid,r,c+1,n,m,memo),sa1);
        
        return memo[r][c]=sa1+grid[r][c];
    }
}