# problem1 

# https://leetcode.com/problems/trapping-rain-water/

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len (height)
        l_arr = [0]*n
        r_arr = [0]*n
        total = 0
        max_val = float('-inf')
        for i in range(n):
            max_val = max(height[i],max_val)
            l_arr[i]= max_val

        max_val = float('-inf')
        for i in range(n-1,-1,-1):
            max_val = max(height[i],max_val)
            r_arr[i]= max_val

        for i in range(n):
            min_val = min(r_arr[i],l_arr[i])
            total+= (min_val) - height[i]
        return total