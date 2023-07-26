'''
Problem: Trapping Rain Water
Time Complexity: O(n), length of height array
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        if we get leftwall to be bigger then we process right and vice versa
        whenever traversing if left is greater than leftwall then we shift leftwall to left
        similarly do the same at right side
        otherwise add the water filled into the result
'''

class Solution:
    def trap(self, height: List[int]) -> int:
        lw = 0
        rw = 0
        result = 0

        left = 0
        right = len(height)-1

        while left <= right:
            if lw < rw:
                #process left
                if height[left]>lw:
                    lw = height[left]
                else:
                    result+=lw - height[left]
                left+=1
            else:
                #process right
                if height[right]>rw:
                    rw = height[right]
                else:
                    result+= rw - height[right]
                right-=1
        
        return result


        