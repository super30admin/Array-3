'''
TC: O(n)
SC: O(1)

Intuition: have four pointers, left wall, left, right wall, right

- left and right wall at 0 and hlen - 1 have not serve
- At any point, if left wall <= right wall, we know that it can contribute to overrall volume
- else vice versa

'''
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        
        hlen = len(height)
        
        if hlen <= 2:
            return 0
        
        l, lw, r, rw = 0, 0, hlen - 1, hlen - 1
        vol = 0
        
        while l <= r:
            if height[lw] <= height[rw]:
                if height[lw] >= height[l]:
                    vol += height[lw] - height[l]
                else:
                    lw = l
                l += 1
            else:
                if height[rw] >= height[r]:
                    vol += height[rw] - height[r]
                else:
                    rw = r
                r -= 1
        
        return vol
  
        