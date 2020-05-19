"""
# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

time - O(N)
space - constant
"""

class Solution:
    def trap(self, height):
        if len(height) ==0:
            return 0
        right_max = 0    #to keep track of right max height
        left_max = 0     #to keep track of left max height
        left=0      # left pointer
        right= len(height)-1      #right pointer
        water =0
        while left < right:
            left_max= max(left_max,height[left])        #calculate max left height
            right_max=max(right_max, height[right])       #calculate max right height
            if left_max < right_max:
                water += min(left_max,right_max) - height[left]
                left +=1
            else:
                water += min(left_max, right_max) - height[right]
                right -= 1
        return water

tr = Solution()
print(tr.trap([0,1,0,2,1,0,1,3,2,1,2,1]))
