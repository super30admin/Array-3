// Time Complexity : O(n) where n is the number of elements 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Use of 4 pointers which is not a normal thing
/* Your code here along with comments explaining your approach: Use two pointers left wall (lw) and right wall(rw). We start from left to right.
If the left pointer height is greater than the left wall height (imaginary wall), we  update the left wall height to the max height since we need
taller buildings to cover the water. We move left pointer to the right in either case, since it is checking height with left wall for each instance. Similarly
if the right wall is taller than right pointer, we can cover water => height of the right wall and right pointer is the water covered. We decrement
the right pointer and update the next right wall (imaginary) height at each instance till left pointer cross right pointer.
*/
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){return 0;}
        int lw  =0, rw =0, l =0, r = height.length-1, amount  = 0;
        while(l <= r){
            if(lw < rw){                                                            // left wall is lesser height than right wall
                if(height[l] < lw){                                             // Height of left pointer is lesser than left wall
                    amount += lw - height[l];                                           // Rainwater collected by left wall and neighbor wall
                }
                else {
                    lw = height[l];                                                     // Update the left wall height
                }
                l++;
            } else {
                 if(height[r] < rw){
                    amount += rw - height[r];                                                   // Rainwater collected by right wall and right pointer
                }
                else {
                    rw = height[r];                                                             // Update the right wall height
                }
                r--;
            }
        }
        return amount;                                                                              // Return the result
    }
}