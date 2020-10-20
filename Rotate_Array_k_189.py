#got the intution after reversing the list

#Time - O(n)
# Space - O(1)



class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return None
        lent = len(nums)
        
        if k > lent:
            k = k % lent
        
        if k:
            self.rev(nums,0,lent - 1)
            self.rev(nums,0,k-1)
            self.rev(nums,k, lent - 1)   
    
    
    
    
    
    
    def rev(self,nums, left ,right):
        while left < right:
        
            nums[left], nums[right] = nums[right], nums[left]
            left +=1
            right -=1
        return nums
            
        
        
        
                
        