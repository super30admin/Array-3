# The rotate method rotates an array to the right by k steps.

# Compute the effective rotation using k % n.
# Use a temporary array to store the rotated positions:
# - Place each element from the original array into its new position.
# Copy the rotated array back into the original array.

# TC: O(n) - Single traversal to fill and copy the rotated array.
# SC: O(n) - Space for the temporary rotated array.


from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k = k % n
        rotated = [0] * n

        for i in range(n):
            rotated[(i + k) % n] = nums[i]
        
        for i in range(n):
            nums[i] = rotated[i]