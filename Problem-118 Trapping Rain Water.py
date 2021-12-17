# 42. Trapping Rain Water
# https://leetcode.com/problems/trapping-rain-water/

# Logic: 
# Less efficient: Make a left max so far array and right max so far array. 
# Iterate over the input and take min of the leftmax and rightmax. 
# min - current height will give water at that level.

# Efficient: Have two pointers on the start and end. comapare element at 
# left and right. Which ever is min select that. Check if the current 
# element is greater than leftmax, if yes update leftmax else add to 
# result leftmax-curEle and update left. Do the same for right side if 
# right is less than left.

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def trap(self, height) -> int:
        left = 0
        right = len(height) - 1
        
        res = 0
        left_max = 0
        right_max = 0
        
        while left <= right:
            if height[left] <= height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    res += left_max - height[left]
                left += 1
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    res += right_max - height[right]
                right -= 1
        return res