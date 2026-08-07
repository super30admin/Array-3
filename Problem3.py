## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.

        TIME COMPLEXITY: O(N)
        - Step 1 (reversing all N elements): O(N)
        - Step 2 (reversing first k elements): O(k)
        - Step 3 (reversing remaining N-k elements): O(N - k)
        - Total time = O(N) + O(k) + O(N - k) = O(2N) = O(N), where N is len(nums).

        SPACE COMPLEXITY: O(1)
        - The array is modified in-place using a two-pointer reversal approach.
        - Only a few scalar variables (n, k, l, r) are used, requiring O(1) auxiliary space.
        """
        n = len(nums)
        # Normalize k in case k >= n (rotating by n or a multiple of n results in the original array)
        k = k % n

        # Helper function to reverse elements in-place between indices l and r (inclusive)
        def reverse(l: int, r: int):
            nonlocal nums
            while l < r:
                # Swap boundary elements and shrink the window towards the middle
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1

        # LOGIC OVERVIEW:
        # Example: nums = [1, 2, 3, 4, 5, 6, 7], k = 3

        # Step 1: Reverse the entire array.
        # This moves the last k elements to the front, but in reversed order.
        # [1, 2, 3, 4, 5, 6, 7] -> [7, 6, 5, 4, 3, 2, 1]
        reverse(0, n - 1)

        # Step 2: Reverse the first k elements to restore their original relative order.
        # [7, 6, 5, 4, 3, 2, 1] -> [5, 6, 7, 4, 3, 2, 1]
        reverse(0, k - 1)

        # Step 3: Reverse the remaining n - k elements to restore their original relative order.
        # [5, 6, 7, 4, 3, 2, 1] -> [5, 6, 7, 1, 2, 3, 4]
        reverse(k, n - 1)