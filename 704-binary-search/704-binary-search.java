class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int e = nums.length-1;
        
        while(i<=e){
            int mid = (i+e)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target) e = mid-1;
            else if(nums[mid]<target) i = mid+1;
        }
        
        return -1;
    }
}