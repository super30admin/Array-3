// Time Complexity : O(n^2) n -> no of bars
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Brute force
// Water can only be accumulated if there is a bar taller than current bar on each sides.
// For each bar, we'll calculate leftmax and rightmax and find the difference between current bar and minimum height between leftmax and rightmax.

/*
class Solution {
    public int trap(int[] height) {
        // edge case
        if(height == null || height.length == 0) 
            return 0;
        int leftmax = height[0], rightmax = 0;
        int waterCollected = 0;
        for(int i = 1; i < height.length; i++) {
            if(height[i] > leftmax) {
                leftmax = height[i];
                continue;
            }
            // find rightmax
            rightmax = height[i];
            for(int j = i+1; j < height.length; j++) {
                if(height[j] > rightmax) {
                    rightmax = height[j];
                }
            }
            if(height[i] < leftmax && height[i] < rightmax) {
                waterCollected += Math.min(leftmax, rightmax) - height[i];
            }
        }
        return waterCollected;
    }
}
*/

// Time Complexity : O(n) n -> no of bars
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Considering two pointers
// If there exist a leftmax which is greater than current height and if leftmax is lesser than rightmax, then I know that water can be stored on top of the bar and difference will be taken w.r.t. leftmax. So is the case with rightmax.

class Solution {
    public int trap(int[] height) {
        // edge case
        if(height == null || height.length == 0) 
            return 0;
        int left = 0, right = height.length-1;
        int leftmax = 0, rightmax = 0;
        int waterCollected = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(leftmax < height[left]) {
                    leftmax = height[left];
                }
                else {
                    waterCollected += leftmax - height[left];
                }
                left++;
            }
            else {
                if(rightmax < height[right]) {
                    rightmax = height[right];
                }
                else {
                    waterCollected += rightmax - height[right];
                }
                right--;
            }
        }
        return waterCollected;
    }
}


