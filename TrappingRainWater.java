//https://leetcode.com/problems/trapping-rain-water/submissions/
// Time Complexity :O(n)  
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int trap(int[] height) {
        int result=0;
        int l=0,r=height.length-1;
        int lw=0,rw=0;//left wall and the right wall which store heights
        while(l<=r)
        {
            //which wall is smaller
            if(lw<=rw)
            {
                if(lw<=height[l]) //if left wall is less than left pointer we cannot trap
                {
                    lw=height[l];
                    
                }
                else
                    result+=lw-height[l];
                l++;
                    
            }
            else
            {
                if(rw<=height[r])
                    rw=height[r];
                else
                    result+=rw-height[r];
                r--;
            }
        }
        return result;
    }
}