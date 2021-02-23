# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def trap(self, height: List[int]) -> int:
        """
        use four pointers... 
            -left/right
            -leftWall/rightWall
        """
        res = 0
        
        if not height:
            return res
        
        lw = 0
        rw = 0 
        l = 0
        r = len(height)-1
        
        while l <= r:
            #go left side
            if lw <= rw:
                if height[l] < lw:
                    res += (lw - height[l])
                else:
                    lw = height[l]
                l += 1
            else:
                if height[r] < rw:
                    res += (rw - height[r])
                else:
                    rw = height[r]
                r -= 1
                
        return res
                