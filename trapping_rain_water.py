class Solution(object):
    def trap(self, height):
        l = 0
        r = len(height) - 1
        leftMax = height[l]
        rightMax = height[r]
        res = 0

        while l < r:
            if leftMax < rightMax:
                l += 1
                leftMax = max(height[l], leftMax)
                res += leftMax - height[l]

            else:
                r -= 1
                rightMax = max(height[r], rightMax)
                res += rightMax - height[r]

        return res


# time complexity is O(n)
# space complexity is O(1)
