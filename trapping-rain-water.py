# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left_max = [0] * len(height)
        right_max = 0
        total_water = 0
        
        # Record the max height to the left of every point
        for i in range(1,len(height)):
            # Max to the left is the max of height to the left or current max
            left_max[i] = max(left_max[i-1],height[i-1])
        
        # Record the max height to the right of every point
        # max water - min(left_max, right_max) - height
        for j in range(len(height)-2,0,-1):
            right_max = max(height[j+1], right_max)
            if min(right_max,left_max[j]) - height[j] > 0:
                total_water += min(right_max,left_max[j]) - height[j]
        
        return total_water