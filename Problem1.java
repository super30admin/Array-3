// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Array-3;

public class Problem1 {
    public int trap(int[] height) {
        int n = height.length;
        int l =0;
        int lw=0;
        int r=n-1;
        int rw=n-1;
        int result = 0;

        while(l <= r){
            if(height[lw] <= height[rw]){
                if(height[lw] > height[l]){
                    result += height[lw] - height[l];
                }else{
                    lw = l;
                }
                l++;
            }else{
                if(height[rw] > height[r]){
                    result += height[rw] - height[r];
                }else{
                    rw = r;
                }
                r--;
            }
        }
        return result;
    }
}
