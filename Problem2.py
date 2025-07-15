"""
I implemented the two-pointer technique to calculate trapped rainwater. At each step, I compare the left and right heights to decide which side to process. I keep track of the highest walls seen so far from both ends (leftWall and rightWall). Water is trapped when the current height is less than the corresponding wall height.
Time Complexity: O(n)
Space Compelxity: O(1)
"""
class Solution:
    def trap(self, height: List[int]) -> int:

        left = 0
        right = len(height) - 1
        leftWall = 0
        rightWall = 0
        water = 0
        while left <= right:
            if height[left] <= height[right]:
                if height[left] >= leftWall:
                    leftWall = height[left]
                else:
                    water += leftWall - height[left] 
                left += 1
            else:
                if height[right] >= rightWall:
                    rightWall = height[right]
                else:
                    water += rightWall - height[right] 
                right -= 1
        return water      