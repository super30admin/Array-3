"""
FAANMG Problem #119 {Hard } 

42. Trapping Rain Water

Time Complexity O(n)
Space Complexity:  O(1)
       
Did this code successfully run on Leetcode : Yes

- Use 4 pointers - lw, l, rw, r
l = 0, lw = 0, rw = 0, r = width of the entire horizontal
- If lw == rw, process lw
- if lw < l, then lw = h[l] else trapwater += lw - h[l]
- Similarly, if rw < r, then rw = h[r] else trapwater += rw - h[r]
- Return trapwater

@name: Rahul Govindkumar
"""

class Solution:
    def trap(self, height: List[int]) -> int:
        # Get the length of the height array
        n = len(height)
        # Initialize two pointers, one starting from the left and the other from the right
        left, right = 0, n - 1
        
        # Initialize two variables to store the maximum height from the left and right
        left_wall, right_wall = 0, 0
        
        # Initialize a variable to store the trapped water
        trapped_water = 0
        
        # Use two pointers to iterate towards the center
        while left <= right:
            
            # If the height at the left wall is lower
            if left_wall <= right_wall:
                
                # # If the height at the left pointer is larger than the current left_wall, update left_wall
                if height[left] > left_wall:
                    left_wall = height[left]
                    
                # If the height at the left pointer is lower than the current left_wall, add the trapped water
                else:
                    trapped_water += left_wall - height[left]
                left += 1
                
            # If the height at the right pointer is lower,
            else:
                # If the height at the right pointer is larger than the current right_wall, update right_wall
                if height[right] > right_wall:
                    right_wall = height[right]
                    
                # If the height at the right pointer is lower than the current right_wall, add the trapped water
                else:
                    trapped_water += right_wall - height[right]
                right -= 1
                
        # Return the trapped water
        return trapped_water