# Time complexity - O(n) 
# Space Complexity: O(1) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : use right/left and left wall / right wall pointers


class Solution:
    def trap(self, height: List[int]) -> int:
        res = 0

        if not height:
            return res

        lw = 0
        rw = 0 
        l = 0
        r = len(height)-1

        while l <= r:
            #go left side
            if lw <= rw:
                if height[l] < lw:
                    res += (lw - height[l])
                else:
                    lw = height[l]
                l += 1
            else:
                if height[r] < rw:
                    res += (rw - height[r])
                else:
                    rw = height[r]
                r -= 1

        return res
