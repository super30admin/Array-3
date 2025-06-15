# Time Complexity : O(n)
# Space Complexity : O(1)
# Approach:
# 1. Use four pointers, two starting from the left and two from the right.
# 2. lw and rw are used to track the left and right bigger walls that will help trap water.
# 3. At each step, we will either be able to trap water from the left or the right side.
# 4. We will always move the pointer that has the smaller wall height.

class Solution:
    def trap(self, height):
        n = len(height)
        trapped_water = 0
        l, lw = 0, 0
        r, rw = n-1, n-1

        while l <= r:
            if height[rw] > height[lw]:
                if height[lw] > height[l]:
                    trapped_water += height[lw] - height[l]
                else:
                    lw = l
                l += 1
            else:
                if height[rw] > height[r]:
                    trapped_water += height[rw] - height[r]
                else:
                    rw = r
                r -= 1

        return trapped_water

# Time Complexity : O(2n)
# Space Complexity : O(1)
# Approach:
# 1. Find the maximum height and its index.
# This height will be the boundary for trapping water, on the left and right sides.
# 2. Traverse from the left to the maximum index, calculating trapped water.
# 3. Traverse from the right to the maximum index, calculating trapped water. 
class Solution:
    def trap(self, height):
        n = len(height)
        trapped_water = 0
        maxVal = 0
        maxIdx = -1

        for i in range(n):
            if height[i] > maxVal:
                maxVal = height[i]
                maxIdx = i

        l, lw = 0, 0
        while l < maxIdx:
            if height[lw] > height[l]:
                trapped_water += height[lw] - height[l]
            else:
                lw = l
            l += 1

        r, rw = n-1, n-1
        while r > maxIdx:
            if height[rw] > height[r]:
                trapped_water += height[rw] - height[r]
            else:
                rw = r
            r -= 1

        return trapped_water

# Time Complexity : O(n^2)
# Space Complexity : O(1)
# Approach:
# # 1. For each index, find the maximum height to the left and right.
# # 2. The trapped water at that index is the minimum of the left and right maximum heights minus the height at that index.
# # 3. If either left or right maximum is zero, no water can be trapped at that index.   
class Solution:
    def trap(self, height):
        n = len(height)
        trapped_water = 0
        for i in range(n):
            left_max = 0
            right_max = 0

            if i > 0:
                for j in range(i-1, -1, -1):
                    if height[j] > height[i]:
                        left_max = max(left_max, height[j])
            if i < n-1:
                for k in range(i+1, n):
                    if height[k] > height[i]:
                        right_max = max(right_max, height[k])
            
            if left_max == 0 or right_max == 0: continue
            trapped_water += min(left_max, right_max) - height[i]
    
        return trapped_water

# Time Complexity : O(2n)
# Space Complexity : O(n)
# Approach:
# 1. Use a stack to keep track of indices and heights.
# We will maintain a monotonic stack where the heights are in decreasing order.
# 2. For each height, if it is greater than the height at the top of the stack, and the stack is not empty, we pop from the stack.
# 3. The popped height will be the bottom of the water trapped.
# And the top of the stack will give us the left boundary.
# 4. The current height will give us the right boundary.
class Solution:
    def trap(self, height) -> int:
        stack = []
        waterTrapped = 0
        for i in range(len(height)):
            while stack and stack[-1][1] < height[i]:
                idx, h = stack.pop()
                if stack:
                    effHeight = min(height[i], stack[-1][1]) - h
                    width = i - stack[-1][0] - 1
                    waterTrapped += effHeight * width
            stack.append([i, height[i]])
        return waterTrapped