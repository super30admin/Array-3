from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        """
            https://leetcode.com/problems/trapping-rain-water/
            Time Complexity - O(n)
            Space Complexity - O(n)
            Find the running max for the index from the left end of the array and the right end of the array. Then to
        find the water trapped do min(runningMax[left], runningMax[right]) - length of building) to get the amount of water
        trapped.
        """

        # Calculate the running left max from left to right and running right max from right to
        # left for each node
        # after calculating find min(left, right) and subtract current height
        if not height:
            return 0

        n = len(height)
        leftMax = [0 for _ in range(len(height))]
        rightMax = [0 for _ in range(len(height))]

        for i in range(1, n):
            leftMax[i] = max(leftMax[i - 1], height[i - 1])

        for i in reversed(range(0, n - 1)):
            rightMax[i] = max(rightMax[i + 1], height[i + 1])

        totalWater = 0
        for i in range(0, n):
            currentWater = min(leftMax[i], rightMax[i]) - height[i]
            if currentWater < 0:
                currentWater = 0
            totalWater += currentWater
        return totalWater


if __name__ == '__main__':
    print(Solution().trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
