# Time Complexity :
# O(N)

# Space Complexity :  
# O(1)  

# Approach:
# Two pointer approach, use leftWall and rightWall as the pointers alongs with the left and right pointers.
# We need those leftWall and RightWall pointer to iteratively find where we can create a slot for holding water.

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #===============> Approach: Two pointers, TC = O(n), SC = O(1) <=======================#
        if not height or len(height)==0:
            return 0
        
        lw = 0
        rw = 0
        l = 0
        r = len(height)-1
        total = 0

        while(l <= r):
            if lw <= rw:
                if lw >= height[l]:
                    total = total + (lw - height[l])
                else:
                    lw = height[l]
                l += 1
            else:
                if rw >= height[r]:
                    total = total + (rw - height[r])   
                else:
                    rw = height[r]
                r -= 1
        
        return total