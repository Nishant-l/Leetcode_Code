class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        boolean ans = false;
        
        while(start<=end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                ans = isPalandrome(s,start+1,end) || isPalandrome(s,start,end-1);
                return ans;
            }
        }
        
        return true;
    }
    
    public boolean isPalandrome(String s, int start, int end){
         while(start<=end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else return false;
        }
        
        return true;
    }
}