class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        # missed modulo edge case
        if(k>=len(nums)):
            k = k%len(nums)
        for i in range(0,len(nums)//2):
            nums[i],nums[len(nums)-1-i] = nums[len(nums)-1-i], nums[i]
        
        for i in range(0,k//2):
            nums[i],nums[k-1-i] = nums[k-1-i], nums[i]
            
        
        for i in range(k, (len(nums)+k)//2):
            nums[i],nums[len(nums)-1+k-i] = nums[len(nums)-1+k-i], nums[i]
        
