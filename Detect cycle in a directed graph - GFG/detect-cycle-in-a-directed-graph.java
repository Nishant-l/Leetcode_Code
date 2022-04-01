// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[] = new int[V];
        
        for(int i = 0; i<V; i++){
            if(vis[i]==0){
                if(dfs(adj,vis,i)) return true;;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int vis[], int pos){
        vis[pos] = 1;
        
        for(int nbr: graph.get(pos)){
            if(vis[nbr]==0){
                if(dfs(graph,vis,nbr)) return true;;
            }else if(vis[nbr]==1){
                return true;
            }
        }
        
        vis[pos] = 2;
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> graph, int vis[], int pos){
        LinkedList<Integer> que = new LinkedList<>();
        
        que.addLast(pos);
        
        while(que.size()>0){
            int size = que.size();
            
            while(size-->0){
                int curr = que.removeFirst();
                
                if(vis[curr] == 1) return true;
                
                vis[curr] = 1;
                // System.out.print(curr+"-->");
                for(int nbr: graph.get(curr)){
                    // System.out.print(nbr);
                    if(vis[nbr]==0){
                        que.addLast(nbr);
                    }
                    // else if(nbr==curr){
                    //     return true;
                    // }
                    // else if(vis[nbr]==1){
                    //     return true;
                    // }
                }
                // System.out.println("||");
                // vis[curr] = 2;
            }
        }
        
        return false;
    }
}