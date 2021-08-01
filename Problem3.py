# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#reverse whole array first then reverse first k and then reverse second n-k list

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if k>= len(nums):
            k = k%len(nums)
        self.rotateArr(nums,0,len(nums)-1)
        self.rotateArr(nums,0,k-1)
        self.rotateArr(nums,k,len(nums)-1)
        
        
    
    
    def rotateArr(self,nums,l,r):
        
        while l < r:
            self.swap(nums,l,r)
            l += 1
            r -= 1
            
    def swap(self,nums,l,r):
        nums[l],nums[r] = nums[r],nums[l]
        
        
        
            
        
            
        
        