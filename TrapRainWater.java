// Time Complexity : O(N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Have 4 ptrs, 2 left and left wall and right and rightwall
*/
public class TrapRainWater {
    public int trap(int[] height) {
        //4 pointer solution...
        if(height==null || height.length==0) return 0;

        int area=0;

        int l=0, lw=0, r=height.length-1, rw=0;

        while(l<=r){
            if(lw<=rw){
                if(lw>height[l]){
                    area+= lw-height[l];
                }else{
                    lw= height[l];
                }
                l++;
            }else{
                if(rw>height[r]){
                    area+= rw-height[r];
                }else{
                    rw= height[r];
                }
                r--;
            }
        }

        return area;
    }
}