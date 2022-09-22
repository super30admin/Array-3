import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) where n = length of height array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//42. Trapping Rain Water (hard) - https://leetcode.com/problems/trapping-rain-water/
class Solution {
 public int trap(int[] height) {
     int result = 0;
     int l = 0, r = height.length-1;
     int lw = 0, rw = 0; // heights of walls
     
     while (l <= r) {
         if (lw <= rw) { // process left side, because there is a right wall acting as dam
             if (height[l] < lw) { // can trap water
                 result += (lw - height[l]);
             } else {
                 lw = height[l];
             }
             l++;
         } else { // process right side, because there is a left wall acting as dam
             if (height[r] < rw) { // can trap water
                 result += (rw - height[r]);
             } else {
                 rw = height[r];
             }
             r--;
         }
     }
     
     return result;
 }
}