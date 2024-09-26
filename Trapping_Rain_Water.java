// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {
        int L = 0;
        int R = height.length-1;
        
        int LW = 0;
        int RW = 0;
        int amount = 0;
        
        while(L<=R){
            if(LW<RW){
                if(LW<height[L]){
                    LW = height[L];
                }
                else{
                   amount+=(LW-height[L]); 
                }
                L++;
            }
            else{
                if(RW<height[R]){
                    RW = height[R];
                }
                else{
                    amount+=(RW-height[R]);
                }
                R--;
            }
        }
        return amount;
    }
}