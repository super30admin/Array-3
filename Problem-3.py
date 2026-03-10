# Time Complexity : O(n), n = length of nums
# Space Complexity : O(1), in-place rotation
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Normalize k to k % n to handle cases where k > n.
# 2. Reverse the entire array.
# 3. Reverse first k elements.
# 4. Reverse remaining n-k elements.
# 5. This results in rotating the array to the right by k steps in-place.

from typing import List

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k %= n
        
        def reverse(start: int, end: int) -> None:
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        
        reverse(0, n - 1)
        reverse(0, k - 1)
        reverse(k, n - 1)