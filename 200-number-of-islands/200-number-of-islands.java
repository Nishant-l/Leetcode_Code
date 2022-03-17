class Solution {
    
    public void dfs(char[][]grid, int i, int j, boolean vis[][]){
        vis[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int dir[]: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]=='1' && !vis[x][y] ){
                dfs(grid,x,y,vis);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        return count;
    }
}