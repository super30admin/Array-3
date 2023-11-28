/* Time Complexity : O(n)) 
 *  n - len of array - height */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


//Two pass soln
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int max = 0;
        int maxIdx = 0;
        for(int i = 0; i < n; i++){
            if(max < height[i]){
                max = height[i];
                maxIdx = i;
            }
        }
        int result = 0;
        //left to maxIdx
        int lw = 0;
        int lp = 0;

        while(lp < maxIdx){
            if(lw <= height[lp]){
                lw = height[lp];
            }else{//can trap water - calculate
                result += (lw - height[lp]);
            }
            lp++;
        }

        //right to maxIdx
        int rw = 0;
        int rp = n-1;

        while(rp > maxIdx){
            if(rw <= height[rp]){
                rw = height[rp];
            }else{//can trap water - calculate
                result += (rw - height[rp]);
            }
            rp--;
        }
        return result;
    }
}