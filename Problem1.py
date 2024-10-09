'''
1. Maintain two pointers left and right. Also have 2 variables to keep a track of the maximum heights on both sides. Initialize the heights to values on the ends.
2. Start iterating the array from the side with lower max height. Move the left/right pointer one step and the capacity to store at any point is given as min(maxLeft, maxRight) - height[curr].
3. Since we are already keeping a check, min would correspond to either leftMax/rightMax curr would be left/right. Append 

TC: O(n)
SC: O(1)
'''

class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        leftMax, rightMax = height[l], height[r]
        res = 0

        while l < r:
            if leftMax < rightMax:
                l += 1
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]
            else:
                r -= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]
        
        return res