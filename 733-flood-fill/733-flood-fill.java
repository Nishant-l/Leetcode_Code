class Solution {
    public void dfs(int[][] graph, int x, int y, int prev, int nc){
        
        graph[x][y] = nc;
        
        int n = graph.length;
        int m = graph[0].length;
        
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int dir[] : dirs){
            int i = x+dir[0];
            int j = y+dir[1];
            
            if(i>=0 && j>=0 && i<n && j<m && graph[i][j]==prev){
                dfs(graph, i, j, prev, nc);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int temp = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        dfs(image, sr, sc, temp, -1);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(image[i][j]==-1){
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
}