# Time Complexity :
# O(N)  - Size of the Matrix

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We first do a pass over the array, find the maximum element. Then start moving from the left and keep computing how much water can be stored.
#This is done by starting by considering first wall as the left wall. If the current wall is greater than the next wall, then we add the difference to the result
#If the next seen wall is greater than lw, we move the left wall to current wall. This is done until the max wall is reached. The same is repeated from the right side as well.

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if n == 0 :
            return 0
        max_pos,max_val = max(enumerate(height) ,key = (lambda x : x[1]))
        result = 0
        lw = height[0]
        i = 0 
        while i < max_pos:
            if lw > height[i] :
                result += lw - height[i]
            else :
                lw = height[i]
            i += 1
        i = n-1
        rw = height[n-1]
        while i > max_pos :
            if rw > height[i] :
                result += rw - height[i]
            else :
                rw = height[i]
            i -= 1 
        return result
