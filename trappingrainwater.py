"""https://leetcode.com/problems/trapping-rain-water/"""


class Solution:
    def trap(self, height: List[int]) -> int:
        """
        Here we will be checking which side to start from, depeneding on the shortness of the wall we will proceed from that side, then we check if the surrounding wall is greater than height l if it is ten we append lw-height[l] to result else we make the wall bigger by assigning it height[pointer]
        TC On
        SC O1

        """
        result = 0
        if height is None:
            return result
        lw = 0
        rw = 0
        l = 0
        r = len(height) - 1

        while l <= r:
            ###start from left side
            if lw <= rw:

                if lw > height[l]:
                    ##we found adjoing wall bigger so water can be trapped
                    result += (lw - height[l]) * 1
                else:
                    lw = height[l]
                l += 1
            ###start from right side
            else:
                ##on right side
                if rw > height[r]:
                    ##we found adjoing wall bigger so water can be trapped
                    result += (rw - height[r]) * 1
                else:
                    rw = height[r]
                r -= 1

        return result