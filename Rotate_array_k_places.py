# Time - O(N)
# Space - O(1)
# first reversing the array and reversing 0 to k and reversing k+1 to end of array

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        i = 0
        j = len(nums)-1
        
        while i<j:
            nums[i],nums[j] = nums[j],nums[i]
            i+=1
            j-=1
        
        if k>len(nums):
            k = k%len(nums)
        i = 0
        j = k-1
        while i<j:
            nums[i],nums[j] = nums[j],nums[i]
            i+=1
            j-=1
        
        i = k
        j = len(nums)-1
        while i<j:
            nums[i],nums[j] = nums[j],nums[i]
            i+=1
            j-=1
        return nums    
