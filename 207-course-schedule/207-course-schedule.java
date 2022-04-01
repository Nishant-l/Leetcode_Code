class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i<numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i= 0; i<prerequisites.length; i++){
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            
            graph[x].add(y);
        }
        
        int vis[] = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
           if(vis[i]==0){
               if(dfs(graph,i,vis)) return false;
           } 
        }
        
        return true;
    }
    
    public boolean dfs(ArrayList<Integer>[] graph, int i, int vis[]){
        vis[i] = 1;
        
        for(int nbr: graph[i]){
            if(vis[nbr]==0){
                if(dfs(graph, nbr, vis)) return true;
            }else if(vis[nbr]==1){
                return true;
            }
        }
        
        vis[i] = 2;
        return false;
    }
}