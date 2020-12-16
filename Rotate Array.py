# Time:- O(2n)
# Space:- O(1)
# Approach:- Three pronged approach:- Reverse the entire array first, then reverse the first k elements and then reverse the last n-k elements.
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k%=len(nums)
        def reverse(start,end):
            while start<end:
                nums[start],nums[end]=nums[end],nums[start]
                start,end=start+1,end-1
        reverse(0,len(nums)-1)
        reverse(0,k-1)
        reverse(k,len(nums)-1)
        