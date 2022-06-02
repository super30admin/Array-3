// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0)
            return 0;
        int l = 0;
        int r = height.length-1;
        int lw = 0;
        int rw = 0;
        int result = 0;
        while(l<=r){
            if(lw<=rw){
                if(height[l]>=lw)
                    lw = height[l];
                else
                    result += lw-height[l];
                l++;
            }
            else{
                if(height[r]>=rw)
                    rw = height[r];
                else
                    result+= rw-height[r];
                r--;
            }
        }
        return result;
    }
}