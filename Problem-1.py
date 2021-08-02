"""
Approach 1: 2 pointers
1) Water cannot be filled unless there are 3 spots i.e there need to be atleast 1 wall on each side

2) initiate 2 pointers on each side of the given list, each pointer needs to be preceeded by a wall so that the water can be stopped

3) if the height of wall is same or less, no need to process that spot since the water cannot be stopped
    a) we just move to the next possible spot in this case

4) if the wall is greater, calculate the units of water that can be stored at that spot
    a) this would be just the difference of height

TC: O(n)
SC: O(1)
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        result = 0
        if n < 3:
            return result
        
        left = 0
        right = n-1
        left_wall = 0
        right_wall = n-1
        
        while left <= right: # need to process the spot where both left and right pointers stop
            if height[left_wall] < height[right_wall]: # process the wall with smaller height. process left side if equal
                if height[left] < height[left_wall]: #can fill water only at this condition
                    result += height[left_wall] - height[left]
                else:
                    left_wall = left
                left += 1
            else: # process right side
                if height[right] < height[right_wall]: # did not use <= since the water will flow away if wall and spot are of same height
                    result += height[right_wall] - height[right]
                else:
                    right_wall = right
                right -= 1
        return result
        
        