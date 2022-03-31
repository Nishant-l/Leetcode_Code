class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1){
                    que.addLast(i*m+j);
                    grid[i][j] = 2;
                }
            }
        }
        
        if(que.size()==n*m) return -1;
        if(que.size()==0) return -1;
        
        int dirs[][] = {{1,0},{0,1},{0,-1},{-1,0}};
        
        int level = 0;
        while(que.size()>0){
            int size = que.size();
            // System.out.println("-----------------------------------"+level);
            while(size-->0){
                int idx = que.removeFirst();
                
                int i = idx/m;
                int j = idx%m;
                
                // if(grid[i][j]==2) continue;
                
                for(int[] dir: dirs){
                    int x = i+dir[0];
                    int y = j+dir[1];
                    
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0){
                        que.addLast(x*m+y);
                        grid[x][y] = 2;
                        // System.out.println(x+"<-->"+y);
                    }
                }
            }
            
            level++;
        }
        
        return level-1;
    }
}