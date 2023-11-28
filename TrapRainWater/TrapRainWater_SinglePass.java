/* Time Complexity : O(n)) 
 *  n - len of array - height */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//Single pass soln
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int lw = 0;
        int lp = 0;
        int rw = 0;
        int rp = n-1;

        while(lp <= rp){
            if(lw <= rw){
                //process left
                if(lw <= height[lp]){
                    lw = height[lp];
                }else{//can trap water - calculate
                    result += (lw - height[lp]);
                }
                lp++;
            }else{
                //process right
                if(rw <= height[rp]){
                    rw = height[rp];
                }else{//can trap water - calculate
                    result += (rw - height[rp]);
                }
                rp--;
            }
        }

        return result;
    }
}