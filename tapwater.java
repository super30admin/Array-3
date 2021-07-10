// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
        int L = 0;
        int R = height.length-1;
        int lw =0,rw=0;
        int out = 0;
        while(L<=R)
        {
            if(lw<rw)
            {
                if(lw<height[L])
                {
                    lw = height[L];
                }
                else
                {
                    out+=lw-height[L];
                }
                L++;
            }
            else
            {
                if(rw<height[R])
                {
                    rw = height[R];
                }
                else
                {
                    out+=rw-height[R];
                }
                R--;
            }
        }
        return out;
    }
}