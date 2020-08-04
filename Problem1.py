"""
// Time Complexity : O(n), 
// Space Complexity : O(1), no extra
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution(object):
    def trap(self, height):
        """
        THREE PASS APPROACH 
        :type height: List[int]
        :rtype: int
        """
        """
        l_max = [0] * len(height)
        r_max = [0] * len(height)
        
        running_max = 0
        
        for i in range(len(height)):
            if height[i] > running_max:
                running_max = height[i]
                l_max[i] = height[i]
            else:
                l_max[i] = running_max
                
        running_max = 0
        
        for i in range(len(height)-1, -1, -1):
            if height[i] > running_max:
                running_max = height[i]
                r_max[i] = height[i]
            else:
                r_max[i] = running_max
                
        res = [0] * len(height)
        
        for i in range(len(height)):
            tmp = min(l_max[i], r_max[i]) - height[i]
            if tmp < 0:
                res[i] = 0
            else:
                res[i] = tmp
                
        return sum(res)
        """
        
        lw = rw = 0 #heights of right and left walls
        #two pointers at the eiher ends
        l = 0
        r = len(height) - 1
        
        res = 0
        while l <= r: #while the pointers dont cross
            
            if lw <= rw: #if left wall is lower than or equal to the right wall, we process left side
                if lw > height[l]: #water can be filled if height of wall is greater than the current height
                    res += lw - height[l] #add unit of water to result 
                else:
                    lw = height[l] #else move ahead
                l += 1
                
            else: #similarly for right side 
                
                if rw > height[r]:
                    res += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
                
        return res
        