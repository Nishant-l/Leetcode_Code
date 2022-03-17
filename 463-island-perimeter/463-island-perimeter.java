class Solution {
    public int dfs(int[][] grid, int i, int j, boolean visited[][]){
        visited[i][j] = true;
        int count = 0;
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                count+=1;
            }
            if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && grid[x][y]==1){  
                ans+=dfs(grid,x,y,visited);
            }
        }
        return ans+(4-count);
        
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean vis[][] = new boolean[n][m];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    return dfs(grid,i,j,vis);
                }
            }
        }
        return -1;
    }
}