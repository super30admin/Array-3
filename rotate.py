# Time Complexity : O(k)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        d = k % len(nums)
        if d == 0:
            return nums
        else:
            while d != 0:
                a = nums[len(nums)-1]
                nums.pop()
                nums.insert(0 , a)
                d -= 1
            return nums
