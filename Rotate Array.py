class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        
        """
        n = len(nums)
        k = k % n
        low = n - k
        high = n - 1
        while(low < high):
            nums[low], nums[high] = nums[high], nums[low]
            low += 1
            high -= 1
            
        low = 0
        high = n - k - 1
        while(low < high):
            nums[low], nums[high] = nums[high], nums[low]
            low += 1
            high -= 1
        
        low = 0
        high = n - 1
        while(low < high):
            nums[low], nums[high] = nums[high], nums[low]
            low += 1
            high -= 1
            
        return nums
        
    
        
            
        
            
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
#         for i in range(len(nums)-1):
#             k=nums[i+1]
#             nums[i+1] 
        
        
