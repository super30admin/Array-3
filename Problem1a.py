class Solution(object):
    def trap(self, height):
        """
        Time complexity - O(n)
        Space complexity - O(1)

        :type height: List[int]
        :rtype: int
        """
        # Step 1: Find the index (maxIdx) and height (maxi) of the highest bar in the elevation map.
        maxIdx = 0  # Initialize the index of the highest bar.
        maxi = 0     # Initialize the height of the highest bar.

        for i in range(0, len(height)):
            # Compare the current bar's height with the current maximum height.
            if maxi < height[i]:
                # Update the maximum height if the current bar is higher.
                maxi = height[i]
                maxIdx = i        # Update the index of the highest bar.

        # Step 2: Calculate the trapped water on the left side of the highest bar (up to maxIdx).
        # Initialize the "low" variable to keep track of the previous lowest bar.
        low = 0
        # Initialize the variable to store the total trapped water.
        result = 0

        for i in range(0, maxIdx):
            # If the current bar's height is lower than the previous lowest bar (low).
            if height[i] < low:
                # Calculate and add the trapped water volume.
                result += low - height[i]
            else:
                # Update the "low" variable to the new lowest bar.
                low = height[i]

        # Step 3: Calculate the trapped water on the right side of the highest bar (from the end to maxIdx).
        # Initialize the "rightwall" variable to keep track of the previous rightmost wall.
        rightwall = 0

        for i in range(len(height) - 1, maxIdx, -1):
            # If the current bar's height is lower than the previous rightmost wall.
            if height[i] < rightwall:
                # Calculate and add the trapped water volume.
                result += rightwall - height[i]
            else:
                # Update the "rightwall" variable to the new rightmost wall.
                rightwall = height[i]

        # Step 4: Return the total trapped water.
        return result
