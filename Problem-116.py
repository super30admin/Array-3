'''
Rotate array - 189 - https://leetcode.com/problems/rotate-array/
time complexity - O(N)
space complexity -O(N)

Approach - 1) reverse all elements
           2) Reverse elements from 0 to k-1
           3) reverse from k till end
           
'''
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k=k%len(nums)
        self.reverse(nums,0,len(nums)-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,len(nums)-1)
        return nums
        
        
        
    def reverse(self,nums,low,high):
        while low<high:
            nums[low],nums[high]=nums[high],nums[low]
            low=low+1
            high=high-1
        