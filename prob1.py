# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# maintain left and right pointers and left wall and right wall
# check height of left is less than left wall and height of right is less than right wall
# intuition behind lw and rw is 
# this gives a guarantee that there is a trapping on the other side

class Solution:

    def trap(height):

        if len(height) == 0 or height is None:
            return 0
        result = 0
        l, r = 0, len(height) - 1
        lw, rw = 0, 0

        while l <= r:

            if lw <= rw:
                if height[l] < lw:
                    result += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            
            else:
                if height[r] < rw:
                    result += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        
        return result