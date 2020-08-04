# Time Complexity : O(n)[n = length of nums list]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach : Two pointers with walls
# 1. If we use only two pointers, then L cannot trap water with R since there walls in between(unlike Container with most water problem)
# 2. So we two walls on each side to trap water. Left wall forms traps with left pointer and Right wall forms traps with right pointer
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:return 0
        n = len(height)
        left_wall, right_wall = 0,0 # heights
        left, right = 0, n-1
        res = 0
        while left <= right: # process left side
            if left_wall <= right_wall:
                if left_wall > height[left]:   # water can be trapped
                    res +=  (left_wall - height[left])
                else:
                    left_wall = height[left]
                left+=1
            else:  # process right side
                if right_wall > height[right]:  # water can be trapped
                    res +=  (right_wall - height[right])
                else:
                    right_wall = height[right]
                right-=1
        return res