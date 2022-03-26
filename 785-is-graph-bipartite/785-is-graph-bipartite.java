class Solution {
    
    public boolean bfs(int[][] graph, int src, int[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        int level = 0;
        que.addLast(src);
        
        while(que.size()>0){
            int size = que.size();
            
            while(size-->0){
                int curr = que.removeFirst();
                if(vis[curr]!=-1){
                    int actualColor = vis[curr];
                    if(actualColor!=level) return false;
                    continue;
                }
                vis[curr]=level;
                for(int nbr : graph[curr]){
                    if(vis[nbr]==-1){
                        que.addLast(nbr);
                    }
                }
            }
            
            level=(level+1)%2;
        }
        return true;
    }
    
    
    public boolean isBipartite(int[][] graph) {
        int vtces = graph.length;
        int vis[] = new int[vtces];
        for(int i = 0; i<vtces; i++){
            vis[i] = -1;
        }
        boolean ans = true;
        for(int i = 0; i<vtces; i++){
            if(vis[i]==-1){
                ans=ans&&bfs(graph,i,vis);
            }
        }
        return ans;
    }
}