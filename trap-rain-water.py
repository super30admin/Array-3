# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        area = 0

        # heights left wall(lw) right wall (rw)
        lw = 0
        rw = 0

        # pointers
        l = 0
        r = len(height)-1

        while l < r:

            if height[l] < height[r]:
                # if left height is smaller than left wall then make left height as left wall
                if height[l] > lw:
                    lw = height[l]

                # else store the water
                else:
                    area += lw - height[l]

                l = l + 1

            else:
                # if right height is smaller than right wall then make right height as right wall
                if height[r] > rw:
                    rw = height[r]

                # store water
                else:
                    area += rw - height[r]

                r = r - 1

        return area
