class Solution:
    def rotate(self, nums, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Time Complexity - O(n)
        # Space Complexity - O(1)
        # Reverse the whole array and then reverse the first k elements and then the next k-n elements
        if nums is None:
            return nums
        n = len(nums)

        if k > n:
            k = k % n

        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)

    def reverse(self, nums, l, r):
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1