class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #         Approach 1 - no extra space. swap/rotate kth elements one at a time. Time - O(n). space o(1)
        #         k %= len(nums)

        #         for i in range(k):
        #             previous = nums[-1]
        #             for j in range(len(nums)):
        #                 nums[j], previous = previous, nums[j]

        #       Approach 2 -  Create an extra array. Time = O(n) space complexity O(n)
        #         n = len(nums)
        #         extraarray = [0] * n
        #         for i in range(n):
        #             extraarray[(i + k) % n] = nums[i]
        #         nums[:] = extraarray

        # Approach 3 - Cyclic replacements - constant extra space is used

        # Approach 4 - Using Reverse. This appriach is similar to the 1st approach. here a new reverse method is crated to swap elements
        # time complexity O(n) space - O(1)
        n = len(nums)
        k %= n

        self.reverse(nums, 0, n - 1)  # reverse ALL the nums in the array
        self.reverse(nums, 0, k - 1)  # reverse first k elements
        self.reverse(nums, k, n - 1)  # reverse last n-k elements

    def reverse(self, nums: list, start: int, end: int) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start = start + 1
            end = end - 1