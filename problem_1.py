# Time Complexity - O(n)
# Spce Complexity - O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        l = 0 
        lw = 0 
        r = n-1 
        rw = 0 
        res = 0

        while l <= r :
            if (lw <= rw):

                if (lw < height[l]):
                    lw = height[l]

                else :
                    res += lw - height[l]
                l += 1
            else :
                if (rw < height[r]):
                    rw = height[r]

                else :
                    res += rw - height[r]
                r -= 1 
        return res


