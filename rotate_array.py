"""
Time Complexity : O(n) where n is the number of elements in nums
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach:
Three Steps:
1. Reverse whole array
2. Reverse first k elements
3, Revers n-k elements
Above steps order does not matter.

Input Array: 1 2 3 4 5, k = 3
Step 1: 5 4 3 2 1
Step 2: 3 4 5 2 1
Step 3: 3 4 5 1 2
"""


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def swap(i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

        if k == len(nums):
            return nums
        if k > len(nums):
            k = k - len(nums)
        ptr1 = len(nums) - k
        ptr2 = len(nums) - 1

        # Step 1: Reverse first k elements
        while ptr1 < ptr2:
            swap(ptr1, ptr2)
            ptr1 += 1
            ptr2 -= 1

        # Step 2: Revers n-k elements
        ptr1 = 0
        ptr2 = len(nums) - k - 1
        while ptr1 < ptr2:
            swap(ptr1, ptr2)
            ptr1 += 1
            ptr2 -= 1

        # Step 3: Reverse whole array
        ptr1 = 0
        ptr2 = len(nums)-1
        while ptr1 < ptr2:
            swap(ptr1, ptr2)
            ptr1 += 1
            ptr2 -= 1
