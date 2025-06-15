# Time Complexity : O(n)
# Space Complexity : O(1)
# Approach:
# 1. Reverse the entire array.
# 2. Reverse the first k elements.
# 3. Reverse the remaining n-k elements.
# This way, we are rotating the array in-place without using extra space.
class Solution:
    def rotate(self, nums, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Helper function to reverse a portion of the array
        def reverse(l, r):
            while l < r:
                tmp = nums[r]
                nums[r] = nums[l]
                nums[l] = tmp
                l += 1
                r -= 1
        n = len(nums)
        # Normalize k to avoid unnecessary full rotations
        k = k % n
        # Reverse the entire array, then reverse the first k elements and the rest
        reverse(0, n-1)
        reverse(0, k-1)
        reverse(k, n-1)

# Time Complexity : O(n)
# Space Complexity : O(1)
# Approach:
# 1. Reverse the first n-k elements.
# 2. Reverse the last k elements.
# 3. Reverse the entire array.
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
        reverse(0, n-k-1)
        reverse(n-k, n-1)
        reverse(0, n-1)