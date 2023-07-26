class Solution(object):
    def trap(self, height):
        """
        Time complexity = O(n)
        Space complexity = O(1)
        :type height: List[int]
        :rtype: int
        """
        leftwall, rightwall, result = 0, 0, 0   # Initialize variables for left wall, right wall, and the total trapped water.
        left = 0   # Initialize the left pointer.
        right = len(height) - 1   # Initialize the right pointer.

        # Use two pointers (left and right) to traverse towards the center.
        while left <= right:   # Use <= instead of <
            # If left wall is lower or equal, process the left side.
            if leftwall <= rightwall:
                # If the left wall is higher than the current bar, calculate the trapped water and add to the result.
                if leftwall > height[left]:
                    result += leftwall - height[left]
                else:
                    leftwall = height[left]   # Update the left wall height.

                left += 1   # Move the left pointer to the right.

            # If right wall is lower or equal, process the right side.
            else:
                # If the right wall is higher than the current bar, calculate the trapped water and add to the result.
                if rightwall > height[right]:
                    result += rightwall - height[right]
                else:
                    rightwall = height[right]   # Update the right wall height.

                right -= 1   # Move the right pointer to the left.

        # Return the total trapped water.
        return result
