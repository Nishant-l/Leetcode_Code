class Solution {
    public boolean dfs(int[][] grid1, int[][] grid, int i, int j){
        grid[i][j] = 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
         boolean ans = true;
        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                ans = dfs(grid1,grid,x,y) && ans;
            }
        }
        
        if(grid1[i][j]==0) return false;
        
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid2[i][j]==1){
                    boolean smallAns = dfs(grid1,grid2,i,j);
                    if(smallAns) ans++;
                }
            }
        }
        return ans;
    }
}