class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        LinkedList<Integer> ans = new LinkedList<>();
        
        int n = graph.length;
        int m = graph[0].length;
        
        int[] vis = new int[n];
        
        for(int i = 0; i<n; i++){
            if(vis[i]==0){
                dfs(graph,i,ans,vis);
            }
        }
        
        LinkedList<Integer> newAns = new LinkedList<>();
        
        for(int i = 0; i<n; i++){
            if(vis[i]==2){
                newAns.add(i);
            }
        }
        return newAns;
    }
    
    public boolean dfs(int[][] graph, int i, LinkedList<Integer> ans, int[] vis){
        int n = graph.length;
        int m = graph[0].length;
        
        vis[i] = 1;
        boolean hasCycle = false;
        
        for(int nbr: graph[i]){
            if(vis[nbr]==0){
                hasCycle = hasCycle || dfs(graph,nbr,ans,vis);
            }else if(vis[nbr]==1){
                hasCycle = true;
            }
        }
        
        if(hasCycle) return true;
        
        ans.addLast(i);
        vis[i] = 2;
        return false;
    }
}