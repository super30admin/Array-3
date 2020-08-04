// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    public int trap(int[] height) {
        if(height == null || heigh.length == 0) return 0;
        int result = 0;
        int n = height.length;
        int l = 0, r = n-1, low = 0, rw = 0;
        while(l <= r) {
            if(lw <= rw) { // process left side
                if(lw > height[l]) {
                    result+= lw-height[l]; // rainwater collected by left wall and neighbor wall
                } else {
                    lw = height[l]; // update left wall height
                }
                l++;
            } else { // process right side
                if(rw > height[r]) {
                    result+= rw-height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}