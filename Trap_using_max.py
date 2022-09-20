# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def trap(self, height: List[int]) -> int:
        max_val = height[0]
        n = len(height)
        idx = 0
        
        # find the max height and the index in the list
        for i in range(1,n):
            max_val = max(max_val, height[i])
            if height[i] == max_val:
                idx = i
        res = 0
        # left side
        left = 0
        left_wall = 0
        # process the left side until we reach the max height index
        while left != idx:
            if left_wall > height[left]:
                res += left_wall - height[left]
            else:
                left_wall = height[left]
            left += 1
        # processing right side
        # process the right side until we reach the max height index
        right = n-1
        right_wall = 0
        while right != idx:
            if right_wall > height[right]:
                res += right_wall - height[right]
            else:
                right_wall = height[right]
            right -= 1
        
        return res
                
