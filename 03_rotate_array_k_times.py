#TC: O(n)
#SC: O(1)
#Approach 1: inplace rotate
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        k = k % len(nums) #if k is greater than the length of the array
        
        
        #reverse the entire array
        l , r = 0, len(nums)-1
        while(l<r):
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l+1, r-1
        
        #reverse the 1st k elements
        l , r = 0, k-1
        while(l<r):
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l+1, r-1
            
        #reverse the n-k elements
        l, r = k, len(nums)-1
        while(l<r):
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l+1, r-1