#time: O(n)
#space: O(n)

#brute force
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if(nums==None or len(nums)==0):
            return nums
        
        result=[0 for i in range(len(nums))]
        for i in range(len(nums)):
            if i<=k-1:
                result[i]=nums[len(nums)-k+i]
            else:
                result[i]=nums[i-k]
        for i in range(len(nums)):
            nums[i]=result[i]
        
        