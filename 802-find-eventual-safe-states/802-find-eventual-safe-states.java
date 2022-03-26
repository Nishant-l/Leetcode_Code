class Solution {
    
    public boolean dfs(int[][] graph, int[] vis, int src){
        vis[src] = 1;
        
        // ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i: graph[src]){
            if(vis[i]==1){
                return true;
            }
            if(vis[i]==0){
                boolean smallAns = dfs(graph,vis,i);
                if(smallAns) return true;
            }
        }
        
        vis[src] = 2;
        return false;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int vtces = graph.length;
        
        int vis[] = new int[vtces];
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i<vtces; i++){
            if(vis[i]==0){
                boolean smallAns = dfs(graph,vis,i);
            }
        }
        
        for(int i = 0; i<vtces; i++){
            if(vis[i]==2) ans.add(i);
        }
        return ans;
    }
}