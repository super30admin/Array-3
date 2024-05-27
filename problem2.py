#Time Complexity : O(n)
#Space Complexity : O(1)
#Any problem you faced while coding this : -

#The approach is to maintain left wall and right wall boundaries. The first thing is to find out which one is the greater one and the we try to find trapped water towards that side. We update the wall if we find a new greater height or else we keep on adding the trapped water to the result.

class Solution:
    def trap(self, height: List[int]) -> int:
        lw, rw = 0, 0
        l, r = 0, len(height)-1
        result = 0

        while(l <= r):
            if lw <= rw:
                if lw  > height[l]:
                    result += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                if rw > height[r]:
                    result += rw - height[r]
                else:
                    rw = height[r]
                r -= 1

        return result

                