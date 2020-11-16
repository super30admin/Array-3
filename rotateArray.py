""" Time : O(n^2)
    Space : O(1)
    Leetcode : Yes
    Explanation : Use brute force to swap elements based on their index. can be improved.
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # speed up the rotation
        k %= len(nums)

        for i in range(k):
            previous = nums[-1]
            for j in range(len(nums)):
                nums[j], previous = previous, nums[j]
            
        