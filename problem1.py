"""
We keep a track of all the left-max heights and all the right-max heights and then store them in separate arrays, so the the min of the left and right max is the potential water
we can store and then subtract that from the heights[i]  to get the actual water stored
Space is O(2N) for two arrays we create and time is O(n)"""


class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        leftWall, rightWall = 0, 0
        n = len(height)
        maxLeft, maxRight = [0] * n, [0] * n
        for i in range(n):
            j = -i -1
            maxLeft[i], maxRight[j] = leftWall, rightWall
            leftWall = max(leftWall, height[i])
            rightWall = max(rightWall, height[j])

        totalWater = 0
        for i in range(n):
            potentialWater = min(maxLeft[i], maxRight[i])
            totalWater += max(0, potentialWater - height[i])
        return totalWater