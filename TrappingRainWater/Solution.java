// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * One pass solution
 */
class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int result = 0;
        int l = 0; int lw = height[0];
        int r = n-1; int rw = height[n-1];
        while(l <= r) {
            if(lw < rw) {
                if(lw < height[l]) lw = height[l];
                else result += lw - height[l];
                l++;
            }
            else {
                if(rw < height[r]) rw = height[r];
                else result += rw - height[r];
                r--;
            }
        }
        return result;
    }
}

/**
 * Two pass solution
 */
// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int maxId = 0;
        int max = height[0];
        int result = 0;
        for(int i=1; i<n; i++)
            if(height[i] > max) {
                maxId = i;
                max = height[i];
            }

        int l = 0; int lw = 0;
        while(l < maxId) {
            if(lw > height[l]) result += lw - height[l];
            else lw = height[l];
            l++;
        }

        int r = n-1; int rw = 0;
        while(r > maxId) {
            if(rw > height[r]) result += rw - height[r];
            else rw = height[r];
            r--;
        }

        return result;
    }
}