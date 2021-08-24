class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if len(nums)==0  :
            []
        #if k greater than len(nums) then we will not need to reverse it len(nums), so we will reverse only mod value
        if k>len(nums):
            k=k%len(nums)

        def reverse(nums,l,r):
            while(l<r):
                nums[l],nums[r]=nums[r],nums[l]
                l+=1
                r-=1
            
        
        #Rotate the whole array
        reverse(nums,0,len(nums)-1)
        #Rotate first k, then n-k elements
        reverse(nums,0,k-1)
        reverse(nums,k,len(nums)-1)
        return nums
        #Time O(n)
       #Space O(1)
