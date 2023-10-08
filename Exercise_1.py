# Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)
# // Time Complexity : O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def trap(self, height):
        result = 0
        # two pointers
        left = 0
        right = len(height) - 1
        # maximum element height in left and right
        max_left = 0
        max_right = 0
        while left <= right:
            if height[left] <= height[max_right]:
                # can we tarp water because of the left wall
                if height[left] >= max_left:
                    # not coz height is more, so overflow --> update left wall
                    max_left = height[left]
                else:
                    result += max_left - height[left]
                left += 1
            else:
                # can we tarp water because of the right wall
                if height[right] >= max_right:
                    # not coz height is more, so overflow --> update right wall
                    max_right = height[right]
                else:
                    result += max_right - height[right]
                right -= 1
        return result


height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
sol = Solution()
print(sol.trap(height))
