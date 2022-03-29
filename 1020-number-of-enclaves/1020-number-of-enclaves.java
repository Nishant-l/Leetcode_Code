class Solution {
    public int dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        int count = 0;
        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                count+=dfs(grid,x,y);
            }
        }
        
        count++;
        return count;
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i==0 || j==0 || i==n-1 || j==m-1 ){
                    if(grid[i][j]==1){
                        dfs(grid,i,j);   
                    }
                }
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1){
                    ans+=dfs(grid,i,j);
                }
            }
        }
        
        return ans;
    }
}