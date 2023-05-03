# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k > len(nums):
            k %= len(nums)
        i = 0
        j = len(nums) - k - 1
        while i <=j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1

        i = len(nums) - k
        j = len(nums) - 1
        while i <=j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1

        i = 0
        j = len(nums) - 1

        while i <=j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1

        
