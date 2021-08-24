class Solution:
    def trap(self, height) :
        if height == None or len(height) <= 2:
            return 0

        rain = 0

        n = len(height)
        lw = 0
        l = 0
        rw = 0
        r = n - 1

        while l <= r:
            if lw <= rw:
                # trap water
                if height[l] < lw:
                    rain += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                # trap water
                if height[r] < rw:
                    rain += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return rain