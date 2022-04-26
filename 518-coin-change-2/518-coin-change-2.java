class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n+1][amount+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=amount; j++){
                memo[i][j] = -1;
            }
        }
        return rec(amount,coins,0,memo);
    }
    
    public int rec(int ter, int arr[], int pos, int[][] memo){
        int n = arr.length;
        
        if(ter==0){
            memo[pos][ter] = 1;
            return 1;
        }
        if(pos==n){
            memo[pos][ter] = 0;
            return 0;
        }
        
        if(memo[pos][ter]!=-1) return memo[pos][ter];
        
        int ans = 0;
        for(int i = pos; i<n; i++){
            if(ter-arr[i]>=0){
                ans+=rec(ter-arr[i],arr,i,memo);
            }
        }
        memo[pos][ter]=ans;
        return ans;
    }
}