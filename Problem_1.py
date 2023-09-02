# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        water = curr_peak = 0
        global_peak = max(height)
        for h in height:
            curr_peak = max(h, curr_peak)
            if h < curr_peak:
                water += curr_peak - h
        curr_peak = 0
        for h in reversed(height):
            curr_peak = max(h, curr_peak)
            if curr_peak == global_peak:
                return water
            water -= global_peak - curr_peak