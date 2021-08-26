// Time Complexity :o(N)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
        if(height==null||height.length<=2)
            return 0;
        
        int lw=0,rw=0,l=0,r=height.length-1;
        int result=0;
        
        while(l<=r)
        {
            if(lw<=rw)
            {
                if(height[l]<lw)
                {
                    result+=(lw-height[l]);
                }
                else
                {
                    lw=height[l];
                }
                l++;
            }
            else
            {
                if(height[r]<rw)
                {
                    result+=(rw-height[r]);
                }
                else
                {
                    rw=height[r];
                }
                r--;
            }
        }
        return result;
    }
}