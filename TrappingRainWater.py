from typing import List


class Solution:
    # Time is O(n) and space is O(1). The intuition is to have max index which would act like a dam for both the passes either from left to right
    # or from right to left and we calculate the amount of water being collected at each spot.
    def trapTwoPass(self, height: List[int]) -> int:
        maxIdx = 0
        n = len(height)
        for i in range(n):
            if height[i] > height[maxIdx]:
                maxIdx = i
        res = 0
        maxLeft = 0
        maxRight = 0
        for i in range(1, maxIdx + 1):
            if height[i - 1] > maxLeft:
                maxLeft = height[i - 1]
            if height[i] < maxLeft:
                res += maxLeft - height[i]

        for i in range(n - 2, maxIdx, -1):
            if height[i + 1] > maxRight:
                maxRight = height[i + 1]
            if height[i] < maxRight:
                res += maxRight - height[i]

        return res

    # Time is O(n) and space is O(1). The intuition is same but with two pointers we keep updating the max value for either of the side as
    # that would act as a dam at that position. We don't exactly need the max value in the beginning itself.
    def trapSinglePassTwoPointers(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        maxLeft = 0
        maxRight = 0
        res = 0
        while left <= right:
            if maxLeft < maxRight:
                if height[left] < maxLeft:
                    res += maxLeft - height[left]
                else:
                    maxLeft = height[left]
                left += 1
            else:
                if height[right] < maxRight:
                    res += maxRight - height[right]
                else:
                    maxRight = height[right]
                right -= 1
        return res

    # The time is O(n) and space is O(n) for using stack. The intuition here is to use a monotonically increasing stack and calculate the result which will be
    # min of both left and right height subtracted by current height multiplied with the width
    def trapUsingStack(self, height: List[int]) -> int:
        def trap(self, height: List[int]) -> int:
            stack = [-1]
            res = 0
            for i in range(len(height)):
                while stack[-1] != -1 and height[i] > height[stack[-1]]:
                    popped = stack.pop()
                    if stack[-1] != -1:
                        res += (min(height[stack[-1]], height[i]) - height[popped]) * (i - stack[-1] - 1)
                stack.append(i)

            return res
