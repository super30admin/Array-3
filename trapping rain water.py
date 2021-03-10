# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Use 4 pointers : left wall, right wall, left, right
# run while loop till l<=r
# for each wall we check if there is left and right large wall
# 


class Solution:
    def trap(self, height: List[int]) -> int:
        
        if height == None or len(height) == 0: return 0
        n = len(height)
        lw, rw = height[0], height[n-1]
        l,r,res = 0,n-1,0
        # chek if l<r
        while l<=r:
            #check  if left wall is smaller or equal
            # if it is then proceed with left side
            if lw <= rw:
                # if left wall is higher then we can trap the water
                if lw > height[l]:
                    res += lw - height[l]
                # else we cant hence move wall to j
                else:
                    lw = height[l]
                l += 1
            else:
                if rw > height[r]:
                    res += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return res