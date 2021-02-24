# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        lw = 0
        rw = 0
        l = 0 
        r = len(height) - 1
        result = 0
        
        while(l <= r):
            if(lw < rw):
                # if left wall is shorter, process left side
                if(height[l] <= lw):
                    result += 1 * (lw - height[l])
                    l += 1
                else:
                    lw = height[l]
                    l += 1
            else:
                if(height[r] <= rw):
                    result += 1 * (rw - height[r])
                    r -= 1
                else:
                    rw = height[r]
                    r -= 1
                    
        return result