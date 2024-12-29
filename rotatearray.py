"""
First reverse the entire array
Then reverse the k elements 
Next reverese remaining elements from k
TC: O(n)
SP: O(1)
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k %len(nums)
        nums.reverse()
        i = 0
        j = k-1
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i+=1
            j-=1
        i = k 
        j = len(nums)-1
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i+=1
            j-=1
        