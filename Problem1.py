# // Time Complexity : O(n) where n is the length of the height list.  
# // Space Complexity : O(n) where n is the length of the height list.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def trap(self, height: List[int]) -> int:
        leftMax = [0] * len(height)
        rightMax = [0] * len(height)
        leftMax[0] = height[0]
        for i in range(1,len(height)):
            leftMax[i] = max(height[i],leftMax[i-1])
        rightMax[-1] = height[-1]
        for i in range(len(height)-2,-1,-1):
            rightMax[i] = max(height[i],rightMax[i+1])
        result = [0] * len(height)
        for i in range(len(height)):
            result[i] = min(leftMax[i],rightMax[i]) - height[i]
        return sum(result)
