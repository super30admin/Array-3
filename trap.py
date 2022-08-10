class Solution:
    '''
    Leetcode Solution - most optimal - a new type to rememeber 
    '''
    def trap(self, height: List[int]) -> int:
        if not height or len(height) == 0:
            return 0
        lw , rw = 0, 0
        l , r = 0 , len(height)-1 
        result = 0 
        while l <=  r:
            if lw <= rw:
                if lw > height[l]:
                    result = result + lw - height[l]
                else:
                    lw = height[l]
                l+= 1
            else:
                if rw > height[r]:
                    result = result + rw - height[r]
                else:
                    rw = height[r]
                r -= 1 
        return result
