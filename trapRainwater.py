""" Time : O(n^2)
    Space : O(1)
    Leetcode : Yes
    Explanation : Use brute force to calculate the max element till that node and max element from that element
    Here, calculate area using width * height where width = 1 and height = min of left and right max as
    only the minimum will decide how much water is contained in that element. then sum up this area.
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        
        ans = 0
        for i in range(1,len(height)-1): 
            max_left = max(height[:i])
            max_right = max(height[i+1:])
            waterhere = min(max_left, max_right) - height[i] # *width = 1
            ans += max(0, waterhere) 
        return ans
        