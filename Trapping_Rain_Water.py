# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using two pointers and left wall and right wall
# While left <= right, if lw < rw and check height of left is less than lw then the water can be trapped else set lw to height of left
# Increment left by 1
# Else if height of right is less than rw then again the water can be trapped else set rw to height to right
# Decrement right pointer by 1
# Return result


class Solution:
    def trap(self, height: list[int]) -> int:
        maxheight = float('-inf')
        maxindex = -1
        for i in range(len(height)):
            if height[i] > maxheight:
                maxheight = height[i]
                maxindex = i
        
        lw = 0
        left = 0
        rw = 0
        right = len(height)-1
        result = 0
        while left < maxindex:
            if height[left] < lw:
                result += lw - height[left] * 1
            else:
                lw = height[left]
            left += 1
        while right > maxindex:
            if height[right] < rw:
                result += rw - height[right] * 1
            else:
                rw = height[right]
            right -= 1
        return result
#Time - O(N) 2 pass
#Space - O(1)

class Solution:
    def trap(self, height: list[int]) -> int:
        lw = 0
        rw = 0
        left = 0
        right = len(height)-1
        result = 0
        while left <= right:
            if lw < rw:
                if height[left] < lw:
                    result += lw - height[left] * 1
                else:
                    lw = height[left]
                left += 1
            else:
                if height[right] < rw:
                    result += rw - height[right] * 1
                else:
                    rw = height[right]
                right -= 1
        return result
