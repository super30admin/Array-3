'''
Time Complexity: O(n) where n is length of height list
Space Complexity: O(1)
Run on Leetcode: YES
'''
class Solution:
    def trap(self, height: list[int]) -> int:
        # null
        if len(height) == 0:
            return 0
        n = len(height)
        result = 0
        curr = 0
        slow = 0
        fast = 1
        #first pass
        while fast < n:
            if height[fast] < height[slow]:
                curr += height[slow] - height[fast]
            else:
                result += curr
                curr = 0
                slow = fast
            fast += 1
        curr = 0
        #second pass
        slow = n - 1
        fast = n - 2
        while fast >= 0:
            if height[fast] <= height[slow]:
                curr += height[slow] - height[fast]
            else:
                result += curr
                curr = 0
                slow = fast
            fast -= 1
        return result