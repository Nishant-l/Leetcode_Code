class Solution {
    public void dfs(int[][] grid, int i, int j){
        grid[i][j] = 2;
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][]dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int[]dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0){
                dfs(grid,x,y);
            }
        }
    }
    
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==0){
                        dfs(grid,i,j);  
                    }
                }
            }
        }
        int count = 0;
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==0){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}