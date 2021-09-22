"""
Time Complexity : O(n) where n is the number of elements in heights 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0:
            return 0
        n = len(height)
        # Heights of the left and right wall
        lw = rw = 0
        # Left and right pointers l and r
        l = 0
        r = n - 1
        result = 0
        # We loop through the array and move pointers till they cross each other.
        # If the height of left wall is less or equal the right wall we update the 
        # height of left wall to maximum between height of wall at left pointer and 
        # heigh of left wall or else we calculate maximum between height of wall at 
        # right pointer and height of right wall
        while l <= r:
            if lw <= rw:
                """if height[l] < lw:
                    result += lw - height[l]
                else:
                    lw = height[l]
                l += 1"""
                lw = max(lw, height[l])
                result += lw - height[l]
                l += 1
            else:
                """if height[r] < rw:
                    result += rw - height[r]
                else:
                    rw = height[r]"""
                rw = max(rw, height[r])
                result += rw - height[r]
                r -= 1
        return result
        