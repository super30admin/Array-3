# Time Complexity : O(N) where n is number of elements in the array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums) - 1
        
        if k >= n+1:
            k = k % (n+1)

        self.reverseArray(nums, 0, n)
        self.reverseArray(nums, 0, k-1)
        self.reverseArray(nums, k, n)
        
        
    def reverseArray(self, nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1