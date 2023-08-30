// Time Complexity : O(2n) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Find the max height and its index.
 * 2. From left to maxIdx, if height[left] > height[lw], update left wall and update the result based on left wall.
 * 3. From right to maxIdx, if height[right] > height[rw], update right wall and update the result based on right wall.
 * 4. return result.
 */


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lw = 0, rw = n-1;
        int maxIdx = -1, maxHeight = 0;
        int result = 0;
        for(int i=0; i<n; i++){
            if(height[i] > maxHeight){
                maxIdx = i;
                maxHeight = height[i];
            }
        }

        int left = 1;
        while(left < maxIdx){
            if(height[left] > height[lw]){
                lw = left;
            }else {
                result += height[lw] - height[left];
            }
            left++;
        }

        int right = n-2;
        while(right > maxIdx){
            if(height[right] > height[rw]){
                rw = right;
            }else {
                result += height[rw] - height[right];
            }
            right--;
        }

        return result;
    }
}