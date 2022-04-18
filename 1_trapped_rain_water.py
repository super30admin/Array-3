
// Time Complexity  : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this    : No

class Solution:
    def trap(self, nums: List[int]) -> int:
        
        rmax=float("-inf")
        lmax=float("-inf")
        
        
        l=0
        r=len(nums)-1
        
        water=0
        
        while( l<r):
            lmax=max(lmax,nums[l])
            rmax=max(rmax,nums[r])
            
            if lmax<rmax:
                water = water + lmax-nums[l]
                l=l+1
            else:
                water= water + rmax-nums[r]
                r=r-1
                
        return water
        