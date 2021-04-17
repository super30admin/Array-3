'''
T =O(n)
S = O(1)

Approach:
Rotate the array completley once
Split the array at k%n th index
sort the two arrays at the split point and join
'''

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums or len(nums)==1:
            return nums
        k = k % len(nums)
        for i in range(len(nums)//2):
            nums[i],nums[len(nums)-1-i] = nums[len(nums)-1-i],nums[i]
        for i in range(k//2):
            nums[i],nums[k-i-1] = nums[k-i-1],nums[i]
        for i in range(k,(k+len(nums))//2):
            nums[i],nums[len(nums)-1-i+k] = nums[len(nums)-1-i+k],nums[i] 
        return nums