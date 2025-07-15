from collections import deque
class Solution:
    def trap(self, height: List[int]) -> int:
        maxStack = deque()
        res = 0
        for i in range(len(height)):
            while maxStack and height[maxStack[-1]] < height[i]:
                pop = maxStack.pop()
                if maxStack:
                    width = (i - maxStack[-1] - 1) 
                    res += (width * (min(height[maxStack[-1]], height[i]) - height[pop]))
            maxStack.append(i)
        return res
