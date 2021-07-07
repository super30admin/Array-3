'''
Solution:
1.  For each index, the water that can trapped at that index would be min of (left max till that index and
    right max from that index ) ABOVE THE HEIGHT at that index.
2.  For that we maintain extra space for running max from left and right in separate arrays and compute
    maximum water that can be trapped at each index, sum that up.

Time Complexity:    O(N)    |   Space Complexity:   O(N)
--- Passed all testcases on Leetcode successfully
'''


class TrappingRainWater:
    def trap(self, height: List[int]) -> int:

        #   edge case check
        if (height == None or len(height) == 0):
            return 0

        #   initializations
        n = len(height)
        leftMaxes = [0 for i in range(n)]
        rightMaxes = [0 for i in range(n)]

        #   fill left Running Max from left
        for i in range(1, n):
            leftMaxes[i] = max(leftMaxes[i - 1], height[i - 1])

        #   fill right Running Max fro right
        for i in range(n - 2, -1, -1):
            rightMaxes[i] = max(rightMaxes[i + 1], height[i + 1])

        #   initializing total water trapped
        totalWater = 0

        for i in range(n):

            #   caclculate water that can be trapped for current Index
            currentWater = min(leftMaxes[i], rightMaxes[i]) - height[i]

            #   if less than 0 => don't add
            if (currentWater < 0):
                currentWater = 0

            #   else add
            totalWater += currentWater

        #   return the sum of water trapped
        return totalWater