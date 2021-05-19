## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

class Solution:
    def trap(self, height: List[int]) -> int:
        if height ==None or len(height)==0:
            return 0
        n = len(height)
        lmax=0 
        rmax=0
        left = 0
        right = n-1
        result = 0
        while left<right:
            if height[left]<=height[right]:
                if lmax<=height[left]:
                    lmax = height[left]
                else:
                    result = result + lmax - height[left]
                left = left+1
            else:
                if rmax<=height[right]:
                    rmax = height[right]
                else:
                    result = result + rmax - height[right]
                right = right-1
        return result
    #Time Complexity: O(n) 
    #Space Complexity: O(1)
    #Approach: Use two pointers, one at the start and the other at the end,
    # Compare them and move the pointer that has the least value and if the values of both are same then increment the left.
    #  Simulatnously update the lmax and rmax when a better height is obtained and add it to the result 
    # by subtracting the index value with the height of that pointer. Left and right will store the index values of the heights.