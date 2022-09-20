# Time complexity : O(n)
# Space complexity : O(1) 
# Leetcode : Solved and submitted

class Solution:
    def trap(self, height: List[int]) -> int:
        res = 0
        # placing two pointers at the extreme end
        left, right = 0, len(height) - 1
        # taking the two walls to trap the rain water, whose values are 0
        left_wall, right_wall = 0, 0
        
        # traverse until the left and right pointers don't cross
        while left <= right:
            # processing the walls whose value is smaller
            # choose the left side if left_wall has smaller value
            if left_wall <= right_wall:
                # we check with the heigh of left pointer which will be moving one step ahead of the wall
                if height[left] < left_wall:
                    # if left is less than the left wall, then we calculate the value to trap water
                    res += left_wall - height[left]
                else:
                    # if we encounter a bigger height, then we change the left wall
                    left_wall = height[left]
                # in all cases, we iincrement the left pointer
                left += 1
            # choose the right side if lesser value
            else:
                # check for height of right pointer and right wall
                if height[right] < right_wall:
                    # calculate if it can be trapped
                    res += right_wall - height[right]
                else:
                    # if not then simply move the right pointer ahead
                    right_wall = height[right]
                right -= 1
        # return the final calculated value at the end from both the ends
        return res
