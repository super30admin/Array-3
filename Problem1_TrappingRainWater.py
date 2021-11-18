# Time Complexity: O(n), where n is length of the input array
# Space Complexity: O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height or len(height) == 0:
            return 0

        # Two pointers to move index from left and right
        left, right = 0, len(height) - 1

        # Two variables to store the maximum height through left and right
        lmax = rmax = 0

        result = 0

        # Iterate through the array by moving the pointer with lesser height
        while left < right:
            if height[left] <= height[right]:
                # If curr height is more than the max height, update the max variable else add the height diff to result
                if lmax <= height[left]:
                    lmax = height[left]
                else:
                    result += lmax - height[left]
                left += 1
            else:
                if rmax <= height[right]:
                    rmax = height[right]
                else:
                    result += rmax - height[right]
                right -= 1

        return result