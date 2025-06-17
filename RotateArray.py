# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def rotate(self, nums, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(l, r):
            while l < r:
                tmp = nums[r]
                nums[r] = nums[l]
                nums[l] = tmp
                l += 1
                r -= 1
        n = len(nums)
        k = k % n
        reverse(0, n-1)
        reverse(0, k-1)
        reverse(k, n-1)