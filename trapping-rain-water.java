//Time complexity: O(N)
//Space complexity: O(1)
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            
        }
        int result = 0;
        int lw = 0;
        int rw = 0;
        int left = 0;
        int right = height.length - 1;
        while(left <= right) {
            //if the height of left wall is less the right wall then only we can trap
            //the water from left to right
            if(lw <= rw) {
                //if the current height is less the the left wall
                //means we can trap water on left
                if(height[left] < lw) {
                    result = result + (lw - height[left]);
                }
                else {
                    lw = height[left];
                }
                left++;
            }
            else {
                //if the current height is less the the right wall
                //means we can trap water on right
                if(height[right] < rw) {
                    result = result + (rw - height[right]);
                }
                else {
                    rw = height[right];
                }
                right--;
            }
        }
        return result;
    }
}