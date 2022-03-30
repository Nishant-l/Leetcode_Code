class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        
        boolean vis[] = new boolean[n];
        
        dfs(rooms,vis,0);
        
        boolean ans = true;
        for(int i= 0; i<n; i++){
            ans = ans&&vis[i];
        }
        
        return ans;
    }
    
    public void dfs(List<List<Integer>> rooms, boolean[] vis, int i){
        vis[i] = true;
        
        for(int curr: rooms.get(i)){
            if(!vis[curr]){
                dfs(rooms,vis,curr);
            }
        }
    }
}