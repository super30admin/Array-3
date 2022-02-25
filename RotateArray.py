#Time Complextity o(n) 
# Space Complexuty o(n)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        print(k)
        print(len(nums))
        if k ==0:
            return
#     if k > len of nums then number of notations ins k%len(nums) because if k == n then we donot need to rotate the array    
        if k> len(nums):
            k = k%len(nums)
            
        self.reverse(nums,0,len(nums)-1)
        
        self.reverse(nums,0,k-1)
        
        self.reverse(nums,k,len(nums)-1)
        
    def reverse(self,nums,ptr1,ptr2):
        while(ptr1 <= ptr2):
            
            temp = nums[ptr2]
            nums[ptr2] = nums[ptr1]
            nums[ptr1] = temp
            ptr1 +=1
            ptr2 -=1
        
        
        
  
        
        
            
            
        
        
        