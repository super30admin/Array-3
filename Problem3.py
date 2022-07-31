# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : N/A
# Your code here along with comments explaining your approach: I have followed the optimal approach discussed in the class.
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        n = len(nums)
        def reverse(nums, l, r):
            while(l < r):
                swap(nums, l, r)
                l += 1
                r -= 1
        def swap(nums, l, r):
            temp = nums[l]
            nums[l] = nums[r]
            nums[r] = temp
        reverse(nums, 0, n-1)
        reverse(nums, 0, k-1)
        reverse(nums, k, n-1)