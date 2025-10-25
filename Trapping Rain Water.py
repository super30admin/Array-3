#  Time Complexity : O(N)
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: This code calculates the amount of rainwater trapped between bars of different heights using a two-pass approach. It first finds the index of the tallest bar, then traverses from the left up to that bar and from the right up to that bar, accumulating trapped water wherever the current bar is lower than the running wall height. By using two pointers (lw/l and rw/r), it efficiently computes the result in O(n) time and O(1) space.

class Solution:
    def trap(self, height: List[int]) -> int:
        # TC: 0(n) SC: O(1)
        n = len(height)

        maxVal = 0
        maxIdx = 0

        for i in range(n):
            if height[i] > maxVal:
                maxVal = height[i]
                maxIdx = i
        
        re = 0

        lw, l = 0, 0

        while l < maxIdx:
            if height[lw] > height[l]:
                re += height[lw] - height[l]
            else:
                lw = l
        
            l += 1
        
        rw, r = n - 1, n - 1

        while r > maxIdx:
            if height[rw] > height[r]:
                re += height[rw] - height[r]
            else:
                rw = r
            r -= 1
        
        return re