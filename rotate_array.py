# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        def rev(l, r):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
        
        n = len(nums)
        k %= n
        rev(0, n-1)
        rev(0, k-1)
        rev(k, n-1)