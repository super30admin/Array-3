/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
42. Trapping Rain Water
Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6


 * Solution 1: using logic of finding left min and right max for each index and then calculating the final value   
   Time Complexity : O(n)
 * Space complexity :O(1)

 */

class Solution {
public:
    int trap(vector<int>& height) {
        int height_size = height.size();
        int max_water = 0;
        int left_max = 0, right_max = 0;
        int lidx = 0, ridx = 0;
        
        /* if there are less than equal to 2 buildings no water can be filled */
        if (height_size <= 2) {
            return max_water;
        }
        
        vector<int> left_max_arr(height_size, 0);
        vector<int> right_max_arr(height_size, 0);
        
        left_max = height[0];
        left_max_arr[0] = left_max;
        right_max = height[height_size - 1];
        right_max_arr[height_size - 1] = right_max;
        
        /* find left max starting from iterating from left to right. find right max from right to left */
        for (lidx = 1, ridx = height_size - 2; lidx < height_size && ridx >= 0; lidx++,ridx--) {
            if (left_max < height[lidx]) {
                left_max = height[lidx];
            }
            left_max_arr[lidx] = left_max;
            
            if (right_max < height[ridx]) {
                right_max = height[ridx];
            }
            right_max_arr[ridx] = right_max;
        }
        
        /* Boundary identified. now use that boundary to calculate the water available to be filled in each block */
        for (lidx = 0; lidx < height_size; lidx++) {
            max_water += min(left_max_arr[lidx], right_max_arr[lidx]) - height[lidx];
        }
        return max_water;
    }
};
/* Execute on leetcode platform */


