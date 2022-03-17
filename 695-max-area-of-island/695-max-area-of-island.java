class Solution {
    public int dfs(int grid[][], int i, int j, boolean vis[][]){
        vis[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        
        int area = 0;
        for(int dir[]:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && !vis[x][y] && grid[x][y]==1){
                area+=dfs(grid,x,y,vis);
            }
        }
        
        return area+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int ans = 0;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int smallAns = dfs(grid,i,j,vis);
                    if(smallAns>ans) ans = smallAns;
                    // ans++;
                    // ans+=smallAns;
                }
            }
        }
        return ans;
    }
}