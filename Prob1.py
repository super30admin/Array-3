class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n = len(height)
        l,r = 0,n-1
        lw,rw = 0,0
        area = 0
        # l and r are pointers to check when they cross
        while l<=r:
            # move left wall when smaller
            if lw <= rw:
                #process left side
                if lw>height[l]:
                    #if left wall is greater, we found area
                    area += lw - height[l]
                else:
                    #if no, move the wall
                    lw = height[l]
                l += 1
            else:
                #process right side
                if rw>height[r]:
                    area += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return area
