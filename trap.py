class Solution:
    def trap(self, height: List[int]) -> int:
        """
        Approach:
        1. Use two-pointer technique to scan from both ends toward the center.
        2. Maintain two variables: `leftMax` and `rightMax`, representing the highest bars seen so far from the left and right.
        3. At each step:
           - Move the pointer at the shorter side inward.
           - Update the corresponding max value.
           - Calculate water trapped at that index: max - height[i], and add it to the result.
        4. Continue until the two pointers meet.

        Time Complexity: O(n) — Each bar is visited once.
        Space Complexity: O(1) — Only constant extra space used.
        """
        if not height: return 0

        l, r = 0, len(height) - 1
        leftMax, rightMax = height[l], height[r]
        result = 0

        while l < r:
            if leftMax <= rightMax:
                l += 1
                leftMax = max(leftMax, height[l])
                result += leftMax - height[l]
            else:
                r -= 1
                rightMax = max(rightMax, height[r])
                result += rightMax - height[r]

        return result
