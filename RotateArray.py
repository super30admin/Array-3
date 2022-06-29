# Tc - O(n)
# SC - O(1)
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        def reverse(left, right):
            while left < right:
                temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                left = left + 1
                right = right - 1

        size = len(nums)
        k = k % size
        reverse(size - k, size - 1)
        reverse(0, size-1)
        reverse(k, size-1)
