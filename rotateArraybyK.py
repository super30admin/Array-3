# TC: O(N) since we are iterating over each element.
# SC: O(1) since we do not use any extra space. 
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:

        if k > len(nums): return nums
        """
        Do not return anything, modify nums in-place instead.
        """
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, len(nums) - 1)

    def reverse(self, nums, left, right):
        while left < right:
            self.swap(nums, left, right)
            left += 1
            right -= 1

    def swap(self, nums, left, right):
        temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp