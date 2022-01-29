// Time Complexity :O(n)= length of array
// Space Complexity :O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Two poointer approach

public class Solution1 {
    public int trap(int[] height) {
        if(height.length==0||height==null)
            return 0;
        int count=0;
        int l=0;
        int r=height.length-1;
        int lw=0;
        int rw=0;
        while(l<=r){
// if left wall is smaller than right wall, water will be captured from left as we have a big right wall on the right
// if right wall is smaller than left wall water will be captured from the right as we have a big wall on the left
            if(lw<=rw){
// water captured if height at any index is maller than the wall
                if(lw>height[l]){
                    count=count+(lw-height[l]);
                }
                else{
                    lw=height[l];
                }
                l++;
            }
            else{
                if(rw>height[r]){
                    count=count+(rw-height[r]);
                }
                else{
                    rw=height[r];
                }
                r--;
            }
        }
        return count;
    }
}
