class Solution {
    public void dfs(char[][] board, int i, int j){
        board[i][j] = '$';
        int n = board.length;
        int m = board[0].length;
        
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int[] dir : dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            
            if(x>=0 && y>=0 && x<n && y<m && board[x][y] == 'O' ){
                dfs(board,x,y);
            }
        }
    }
    
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; i<m; j++){
        //         System.out.println(i+" "+j);
        //     }
        // }
        for(int i=0 ; i<n ; i++){
            for(int j = 0; j<m; j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j]=='O'){
                        dfs(board,i,j);
                    }
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j]=='$'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}