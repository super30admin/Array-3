class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # T: O(n), S: O(1)
        l, r = 0, len(nums) - 1
        k = k % len(nums)

        def rev(l, r):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1

        rev(l, r)
        rev(l, k - 1)
        rev(k, r)
