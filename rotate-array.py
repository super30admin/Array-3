# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:

    def reverse(self, nums, start, end):
        while start < end:
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums is None or len(nums) == 0 or k <= 0:
            return nums

        k = k % len(nums)

        d = len(nums) - k

        self.reverse(nums, 0, d-1)
        self.reverse(nums, d, len(nums)-1)
        self.reverse(nums, 0, len(nums)-1)

        return nums
