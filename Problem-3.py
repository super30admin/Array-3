'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        n = len(nums)
        k = k % n

        nums.reverse()
        nums[0:k] = reversed(nums[0:k])
        nums[k:n] = reversed(nums[k:n])