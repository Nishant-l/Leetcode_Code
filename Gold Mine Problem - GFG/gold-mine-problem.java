// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        // int n = M.length;
        // int m = N[0].length;
        int dummAns=0;
        if(n==1){
            for(int j = 0; j<m; j++){
                dummAns+=M[0][j];
            }
            return dummAns;
        }
        int dp[][] = new int[n][m];
        
        for(int j = m-1; j>=0; j--){
            for(int i = 0; i<n; i++){
                if(j==m-1){
                    dp[i][j]=M[i][j];
                }
                else if(i==0 && i+1<n){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1])+M[i][j];
                }else if(i==n-1 && i-1>=0){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1])+M[i][j];
                }else if(i+1<n && i-1>=0){
                    dp[i][j] = Math.max(Math.max(dp[i][j+1],dp[i+1][j+1]),dp[i-1][j+1])+M[i][j];
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans=Math.max(ans,dp[i][0]);
        }
        return ans;
    }
}