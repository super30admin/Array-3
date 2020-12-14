class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 0:
            return

        def reverse(nums, s, e):
            j = 0
            for i in range(s, ((s + e) // 2) + 1):
                temp = nums[e - j]
                nums[e - j] = nums[i]
                nums[i] = temp
                j += 1
                # print('num',nums)
            return nums

        if k >= len(nums):
            k = k % len(nums)  # rotating array by 5 time in a arr of length of 5 is same as rotating by 1
        reverse(nums, 0, len(nums) - 1)  # o(n)
        reverse(nums, 0, k - 1)
        reverse(nums, k, len(nums) - 1)  # O(n)

        # time-o(n) space O(1)