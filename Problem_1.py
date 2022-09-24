"""
Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        """
        TC: O(n)
        SC: O(1)
        """
        l = 0
        r = len(height) -1
        left_wall = 0
        right_wall = 0
        res = 0
        while l <= r:
            # which side to take
            if (left_wall <= right_wall):
                # left side
                if (height[l] < left_wall):
                    # trap water
                    res += (left_wall - height[l])
                else:
                    left_wall = height[l]
                l+=1
                    
            else:
                # right side
                if (height[r] < right_wall):
                    # trap water
                    res += (right_wall - height[r])
                else:
                    right_wall = height[r]
                    
                r -= 1
                
        return res
                    
            
            
        