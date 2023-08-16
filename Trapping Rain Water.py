# Time Complexity : O(n)
# Space Complexity : O(1)
# Code ran on LeetCode
# Store the index of tallest elevation and calculate the water that can be trapped to its left and right separately. Initialize left wall and right wall to zero. Move a pointer towards the max_index and accumulate water that can be captured between the pointer and the corresponding walls.
class Solution:
    def trap(self, height: List[int]) -> int:
        max_idx = 0
        n = len(height)
        for i in range(len(height)):
            if height[i] > height[max_idx]:
                max_idx = i
        lw = 0; right = n - 1

        result = 0

        for i in range(max_idx):
            if height[i] < lw:
                result += lw - height[i]
            else:
                lw = height[i]

        rw = 0
        for i in range(n - 1, max_idx, -1):
            if height[i] < rw:
                result += rw - height[i]
            else:
                rw = height[i]
        return result