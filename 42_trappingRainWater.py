class Solution:
    def trap(self, height: List[int]) -> int:
        maxHeight = max(height)
        maxIndex = height.index(maxHeight)

        # left traverse
        leftWall = 0
        i = result = 0
        while i < maxIndex:
            if height[i] < leftWall:
                result += leftWall - height[i]
            leftWall = max(leftWall, height[i])
            i += 1
        
        # right traverse
        rightWall = 0
        i = len(height) - 1
        while i > maxIndex:
            if height[i] < rightWall:
                result += rightWall - height[i]
            rightWall = max(rightWall, height[i])
            i -= 1
        
        return result

# Problem 42: https://leetcode.com/problems/trapping-rain-water/description/
# Time Complexity O(n)
# Space Complexity O(1)