# Time Complexity : O(n), where n is the length of the list
# Space Complexity : O(1)

class Solution:
    def trap(self, height):
        if not height:
            return 0
        
        water = 0
        left, right = 0, len(height) - 1
        left_wall, right_wall = height[left], height[right]

        while left < right:
            if left_wall <= right_wall:
                water += max(0, left_wall - height[left])
                left += 1
                left_wall = max(left_wall, height[left])
            else:
                water += max(0, right_wall - height[right])
                right -= 1
                right_wall = max(right_wall, height[right])

        return water

# Examples
solution = Solution()

# Example 1
height1 = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
print("Output:", solution.trap(height1))  # Expected Output: 6

# Example 2
height2 = [4, 2, 0, 3, 2, 5]
print("Output:", solution.trap(height2))  # Expected Output: 9

# Example 3
height3 = [0, 0, 0, 0, 0]
print("Output:", solution.trap(height3))  # Expected Output: 0