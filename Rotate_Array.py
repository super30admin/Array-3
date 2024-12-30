# Explain your approach briefly at the top:
# To rotate the array to the right by k steps, we can use the reverse technique:
# 1. Reverse the entire array.
# 2. Reverse the first k elements.
# 3. Reverse the remaining n - k elements.
# This effectively rotates the array in-place with O(1) extra space.

# Time Complexity: O(n), where n is the length of the array, since reversing is linear.
# Space Complexity: O(1), as no additional space is used.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Step 1: Handle cases where k is greater than the length of nums
        n = len(nums)
        k %= n  # Effective rotation steps
        
        # Helper function to reverse a section of the array
        def reverse(start: int, end: int) -> None:
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]  # Swap elements
                start += 1
                end -= 1

        # Step 2: Reverse the entire array
        reverse(0, n - 1)
        
        # Step 3: Reverse the first k elements
        reverse(0, k - 1)
        
        # Step 4: Reverse the remaining n - k elements
        reverse(k, n - 1)
