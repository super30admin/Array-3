class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums or len(nums)==0:
            return  []
        
        k=k%len(nums)
        def reverse(nums,start,end):
            while(start<end):
                temp=nums[start]
                nums[start]=nums[end]
                nums[end]=temp
                start+=1
                end-=1
            
        reverse(nums,0,len(nums)-1)
        reverse(nums,0,k-1)
        reverse(nums,k,len(nums)-1)
        
        return nums
  
            
        