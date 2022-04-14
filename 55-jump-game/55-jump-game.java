class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        if(nums.length<=1) return true;
        return dummy(nums,dp);
    }
    
    public boolean dummy(int[] arr, int dp[]){
        int n = arr.length;
        for(int pos = n-1; pos>=0; pos--){
           if(pos==n-1){
                dp[pos]=2;
               continue;
            } 
            
            int steps = arr[pos];
            int ans = -1;
            for(int i = 1; i<=steps; i++){
                if(pos+i<n){
                    ans=Math.max(ans,dp[pos+i]);
                }
            }

            if(ans<2){
                dp[pos]=1;
            }else if(ans==2){
                dp[pos]=2;
            }
            // System.out.println(pos+"-->"+dp[pos]);
        }
        
        if(dp[0]==2) return true;
        else return false;
        
    }
}