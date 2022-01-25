// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

// We use 4 pointers here, lw, l, rw, r:
// We check if lw <= rw: we consider the left pointers manipulation
// else we cosider right pointers manipulation

// In the manipulation part, we check if the wall is greater than the pointer, if yes we add the water depth to the count variable and move the pointer further
// if no, we update the wall to the pointers spot and move pointer ahead
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;

        int lw=0, rw=0;         //we take left wall and right wall as 0 initially
        int l=0, r=n-1;         // left = first element, right = last element
        int count=0;

        while(l <= r) {
            if(lw <= rw) {
                // We check the left side
                if (lw > height[l]) {
                    count += lw - height[l];
                    l++;
                }
                else {
                    lw = height[l];
                    l++;
                }
            }
            else {
                // We check the right side
                if (height[r] < rw) {
                    count += rw - height[r];
                    r--;
                }
                else {
                    rw = height[r];
                    r--;
                }
            }
        }
        return count;
    }
}