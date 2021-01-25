# Trapping Rain Water 

# Time Complexity : O(N)
# Space Complexity : O(1) as no auxillary space is used
# Did this code successfully run on Leetcode : Yes, with Runtime 48 ms and Memory 14.8 MB 
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Approach
"""
Using two pointer approach, of initialising left pointer and right pointer to 0 and n-1
respectively moving right pointer here. If height of l is less than height of r
we check for height of l to be greater than left max and update left max to height of l
else add the difference to result/output variable which is initialized to 0. Similarly 
for r max.

"""
class Solution:
    def trap(self, height: List[int]) -> int:
        if(height==None or len(height)==0): # Base Case
            return 0
        n=len(height)
        r_max=0 # Initializing Variables
        l_max=0
        l=0 # Left pointers and right pointers
        r=n-1
        result=0
        while(l<=r): 
            if(height[l]<height[r]): # Proceeding in direction where height[l] is less than height[r]
                if(height[l]>=l_max):
                    l_max=height[l]
                else:
                    result+=l_max-height[l]
                l=l+1
            else:
                if(height[r]>=r_max):
                    r_max=height[r]
                else:
                    result+=r_max-height[r]
                r=r-1
        return result
