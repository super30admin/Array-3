class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)

        # So that k is not more than the n
        k = k % n

        def reverse(left, right):
            while left <= right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1

        # First reverse
        reverse(0, n-1)
        # Second reverse
        reverse(0, k-1)
        # Third reverse
        reverse(k, n-1)
