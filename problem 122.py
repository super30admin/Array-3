#  https://leetcode.com/problems/rotate-array

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k%n
        self.rev(nums,k,0,n-1)
        self.rev(nums,k,0,k-1)
        self.rev(nums,k,k,n-1)
    
    def rev(self,nums,k,start,end):
        while(start<=end):
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp

            start += 1
            end -= 1


# TC: O(n)
# SC: O(n)