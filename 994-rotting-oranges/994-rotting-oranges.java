class Solution {
    public int orangesRotting(int[][] grid) {
        
        int fresh=0;
        
        LinkedList<Integer> que = new LinkedList<>();
        
        int n = grid.length;
        int m = grid[0].length;
        
        // boolean vis[] = new boolean[n*m];
        
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    que.addLast(i*m+j);
                    // vis[i*m+j] = true;
                }
            }
        }
        
        if(fresh==0) return 0;
        int level = 0;
        
        while(que.size()>0){
            int size = que.size();
            while(size-->0){
                int curr = que.removeFirst();
                int x = curr/m;
                int y = curr%m;
                for(int dir[]:dirs){
                    int i = x+dir[0];
                    int j = y+dir[1];
                    if(i>=0 && j>=0 && i<n && j<m && grid[i][j]==1){
                        // vis[i*m+j]=true;
                        que.addLast(i*m+j);
                        grid[i][j]=2;
                        fresh--;
                        if(fresh==0){
                            return level+1;
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}