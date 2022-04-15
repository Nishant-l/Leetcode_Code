class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int[] dp = new int[n+1];
        
        return jumpHelper(nums,dp);
    }
    
    public int jumpHelper(int[] nums, int[] dp){
        int n = nums.length;
        
        for(int pos = n-1; pos>=0; pos--){
            if(pos==n-1){
                dp[pos]=0;
                continue;
            } 

            // if(dp[pos]!=0) return dp[pos];

            int steps = nums[pos];

            int ans = (int)(1e8);

            for(int i = 1; i<=steps; i++){
                if(pos+i<n){
                    ans = Math.min(ans,dp[pos+i]);
                }
            }

            dp[pos] = ans+1;
        }
        return dp[0];
    }
}