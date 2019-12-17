'''
Trapping rain water - 42 - https://leetcode.com/problems/trapping-rain-water/
Time complexity - O(N)
Space complexity - O(1)
approach - Two pointers approach, based on limiting factor we are moving the left and right pointer.

we can do using DP that calculates left_max and right_max (where it is calculated from the end), but the space complexity is O(N) and also we need to use 3 for loops.

'''
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)==0: return 0
        # two pointers
        left=0
        right=len(height)-1
        left_max=0
        right_max=0
        res=0
        while left<right:
            left_max=max(left_max,height[left])
            right_max=max(right_max,height[right])
            
            if left_max<right_max:
                res=res+left_max-height[left]
                left=left+1
            else:
                res=res+right_max-height[right]
                right=right-1
        return res
        
            
        