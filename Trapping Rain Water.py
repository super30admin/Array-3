# Time complexity: O(n)
# Space complexity: O(1)
# Approach: take the spaces where the left wall is larger and right wall is larger, while having two pointers and move the pointers towards larger side by handling the smaller case.
# this will avoid the edge cases where, the height of the wall is always increasing or decreasing



class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if n == 0:
            return 0
        l,r = 0 ,n-1
        lw,rw = 0,0
        result =0
        while l <= r:
            if lw <= rw:
                if height[l] < lw:
                    result += lw-height[l]
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
                    
        
        