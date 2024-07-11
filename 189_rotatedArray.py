class Solution:
    def rotateArray(self, nums: List[int], start: int, end: int) -> List:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
        return nums
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        if k == 0:
            return nums
        if n == 1:
            return nums
        k = k % n
        nums = self.rotateArray(nums, 0, n - 1)
        nums = self.rotateArray(nums, 0, k - 1)
        nums = self.rotateArray(nums, k , n - 1)

# Problem 189: https://leetcode.com/problems/rotate-array/description/
# Time Complexity O(n)
# Space Complexity O(n)