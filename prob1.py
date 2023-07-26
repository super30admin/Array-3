# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def trap(self, height: List[int]) -> int:
        maxH = 0
        maxIdx = 0
        for i in range(len(height)):
            maxH = max(maxH, height[i])
            if height[i] == maxH:
                maxIdx = i

        l = 0
        r = len(height) - 1
        res = 0

        for i in range(l, maxIdx+1):
            if height[i] < height[l]:
                res += height[l] - height[i]
            else:
                l = i

        for i in range(len(height)-1, maxIdx-1, -1):
            if height[i] < height[r]:
                res += height[r] - height[i]
            else:
                r = i

        return res