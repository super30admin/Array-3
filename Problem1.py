## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)
class Solution:
    """
    TIME & SPACE COMPLEXITY ANALYSIS:

    Time Complexity: O(n)
    - Pass 1 (Left Max): Iterates through the height array once from left to right (O(n)).
    - Pass 2 (Right Max): Iterates through the height array once from right to left (O(n)).
    - Pass 3 (Trapped Water): Iterates through the height array once to compute total trapped water (O(n)).
    - Total Time Complexity: O(n) + O(n) + O(n) = O(n), where n is the number of elements in the height array.

    Space Complexity: O(n)
    - Two auxiliary arrays (maxLeft and maxRight) of size n are allocated to precompute boundary heights.
    - Total Auxiliary Space Complexity: O(n).
    """

    def trap(self, height: List[int]) -> int:
        n = len(height)
        
        # Arrays to store the maximum height encountered to the left 
        # and right of each position.
        maxLeft = [0] * n
        maxRight = [0] * n
        
        # Fill maxLeft: maxLeft[i] stores the tallest bar to the left of index i
        for i in range(1, n):
            maxLeft[i] = max(maxLeft[i - 1], height[i - 1])
        
        # Fill maxRight: maxRight[i] stores the tallest bar to the right of index i
        for i in range(n - 2, -1, -1):
            maxRight[i] = max(maxRight[i + 1], height[i + 1])
        
        totalWater = 0
        
        # Calculate trapped water at each bar:
        # Water trapped above index i = min(maxLeft[i], maxRight[i]) - height[i]
        for i in range(n):
            totalWater += max(min(maxLeft[i], maxRight[i]) - height[i], 0)
        
        return totalWater