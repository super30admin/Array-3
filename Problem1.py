# Time Complexity : O(N) (Where N is no of total bars)
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Possible water level for each bar can be found as, min of max lenght of bar found on left side and max length of bar found on right side minus current height bar.
# So for every index we can store max bar height on left side and max bar height on right side.
# Than iterate once more to add water as point 1.

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        hlength = len(height)
#       Initialize array to store max heigh on left and max height on right.
        left_max = [0] * hlength 
        right_max = [0] * hlength 
        
#       fill array of max height on left by comparing current height and previous max height on left side.
        left_max[0] = height[0]
        for i in range(1, hlength):
            left_max[i] = max(left_max[i-1], height[i])
            
#       fill array of max height on right by comparing current height and previous max height on right side.
        right_max[-1] = height[-1]
        for i in range(hlength-2, -1, -1):
            right_max[i] = max(right_max[i+1], height[i])
            
        water = 0
#       Update water by taking minimum of left and right side's max heights and subtracting current height from it.
        for i in range(hlength):
            water += min(left_max[i], right_max[i]) - height[i]
            
        return water
