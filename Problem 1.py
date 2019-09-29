# Time Complexity : O(n) where n is length of list
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def trap(self, height: List[int]) -> int:
        # left aand right are the moving pointers
        left = 0
        right = len(height) - 1
        # l_max and r_max is for keeping the track of the highest height
        l_max = r_max = 0
        water = 0

        # till we have reached middle we will iterate
        while left < right:

            # if height of left < right and its height is more than l_max then just update height else find the water that can be filled and increase left
            if height[left] < height[right]:
                if height[left] > l_max:
                    l_max = height[left]
                else:
                    water += l_max - height[left]
                left += 1

            # if height of right <= left and its height is more than r_max then just update height else find the water that can be filled and increase right
            elif height[right] <= height[right]:
                if height[right] > r_max:
                    r_max = height[right]
                else:
                    water += r_max - height[right]
                right -= 1
        return water