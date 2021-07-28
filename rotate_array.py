class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        TC:O(n)
        SC:O(1)
        """
        if k>=len(nums):
            k=k%len(nums)
            
        # [-1,-100,3,99], k=2
        # reverse entire array-[99,3,-100,-1]
        l=0
        r=len(nums)-1
        while l<=r:
            temp=nums[l]
            nums[l]=nums[r]
            nums[r]=temp
            l+=1
            r-=1
        # reverse first k elements-[3,99,-100,-1]
        l=0
        r=k-1
        while l<r:
            temp=nums[l]
            nums[l]=nums[r]
            nums[r]=temp
            l+=1
            r-=1
        
        # reverse elements starts from k+1 to end-[3,99,-1,-100]
        l=k
        r=len(nums)-1
        while l<=r:
            temp=nums[l]
            nums[l]=nums[r]
            nums[r]=temp
            l+=1
            r-=1
        return nums
        
    