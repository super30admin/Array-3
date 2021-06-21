# TC: O(N) since we will be iterating over all the buildings using 2 pointers
# SC: O(1) since we do not use any extra space.

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height or len(height) < 2: 
            return 0
        
        result = 0
        left = left_wall =  right_wall = 0 
        right = len(height) - 1

        while left <= right: 
#             Left side is small, so processing that first
            if left_wall <= right_wall: 
#         if left wall is greatre than height of left building, only then we can trap water
                if left_wall >= height[left]: 
                    result += 1*(left_wall - height[left])
                else: 
#                    else we cannot trap any water, so now height of left building becomes left wall and left is the next new building  
                    left_wall = height[left]
                left += 1
            else: 
#                 right side is smaller
                if right_wall >= height[right]: 
#                     can trap water
                    result += 1* (right_wall - height[right])
                else: 
#                   cannot trap water
                    right_wall = height[right]
                right -= 1
        
        return result
