    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/trapping-rain-water/
    Time Complexity for operators : o(n) .. n is the length of the array
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Iterate loop till L < = R.
                    B) now checl  if LW < RW, if it is then again check for LW <height[L]
                            if it is then LW = height[L]; 
                            else total += LW - height[L];
                    C) now check in else, if it is then again check for RW <height[R]
                            if it is then RW = height[R]; 
                            else total += RW - height[R];
                    D) return total;
    */
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        
        int L = 0, R = height.length - 1;
        int LW = 0, RW = 0;
        int total = 0;
        
        while(L <= R){
            if(LW < RW){
                if(LW < height[L]){
                   LW = height[L]; 
                }else{
                   total += LW - height[L];
                }
                L += 1;
            }else{
                if(RW < height[R]){
                   RW = height[R]; 
                }else{
                   total += RW - height[R];
                }
                R -= 1;
            }
        }
        
        return total;
    }
}