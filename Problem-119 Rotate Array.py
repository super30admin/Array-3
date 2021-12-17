# 189. Rotate Array
# https://leetcode.com/problems/rotate-array/

# Logic: Reverse the entire array. Then reverse 0 to k-1 
# elements and then reverse k to n-1 elements.

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def _reverse(self, nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
        
    def rotate(self, nums, k) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = (k % n)
        
        self._reverse(nums, 0, n-1)
        self._reverse(nums, 0, k-1)
        self._reverse(nums, k, n-1)