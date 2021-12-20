// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        
        int low = 0;
        int high = height.length-1;
        
        int water = 0;
        
        while (low <= high) {
            if (height[low] < height[high]) {
                
                if (height[low] > leftMax) {
                    leftMax = height[low];
                }
                else {
                    water += leftMax - height[low];
                }
                
                low++;
            }
            else {
                if (height[high] > rightMax) {
                    rightMax = height[high];
                }
                else {
                    water += rightMax - height[high];
                }
                
                high--;
            }
        }
        
        return water;
    }
}