class Solution(object):
    def trap(self, height): #T.C -> O(N)
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        result = 0
        l = 0
        lw = height[0]
        r = n-1
        rw = height[-1]
        while l <= r:
            if rw > lw:
                if lw > height[l]:
                    result+= lw - height[l]
                else:
                    lw = height[l]
                l+=1
            else:
                if rw > height[r]:
                    result+= rw - height[r]
                else:
                    rw = height[r]
                r-=1
        return result