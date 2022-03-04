"""
time: O(N) reverse and swaps
space: O(1) extra space
"""

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        print(nums[-k:] )
        nums[:] = nums[-k:] + nums[:-k]