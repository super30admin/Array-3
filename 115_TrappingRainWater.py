'''
Accepted on leetcode(42)
time - O(N)
space - O(1)
Approach:
1. Declare variables, left pointer and right pointer. Also, leftMax, rightMax and result - initialize to 0.
2. Iterate through the heights array given until the left and right pointers meet.
3. Update leftMax and rightMax. Check the condition which is smaller and use that pointer to move. And add to the result.

'''


class Solution:
    def trap(self, height) -> int:
        # edge case
        if len(height) == 0:
            return 0

        # variables declaration
        left = 0
        right = len(height) - 1

        leftMax = 0
        rightMax = 0

        result = 0
        # logic
        while left < right:
            # update left and right max values.
            leftMax = max(leftMax, height[left])
            rightMax = max(rightMax, height[right])
            # increase left if it is smaller else decrease right. Add the difference in heights to the result.
            if leftMax < rightMax:
                result += (leftMax - height[left])
                left += 1
            else:
                result += (rightMax - height[right])
                right -= 1

        return result