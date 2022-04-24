// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int memo[][] = new int[N+1][sum+1];
        return rec(0,sum,arr,memo);
    }
    
    static Boolean rec(int pos, int sum, int[]arr, int[][]memo){
        int n = arr.length;
        if(sum==0){
            memo[pos][sum] = 2;
            return true;
        }
        
        if(pos==n){ 
            memo[pos][sum] = 1;
            return false;
        }
        
        if(memo[pos][sum] == 1 || memo[pos][sum] == 2){
            return memo[pos][sum]==2?true:false;
        }
        
        Boolean ans = false;
        
        if(sum-arr[pos]>=0){
            ans = rec(pos+1,sum-arr[pos],arr,memo);
        }
        
        ans = ans || rec(pos+1,sum,arr,memo);
        
        if(ans) memo[pos][sum] = 2;
        else memo[pos][sum] = 1;
        
        return ans;
    }
}