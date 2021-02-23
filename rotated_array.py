# Time complexity - O(n) 
# Space Complexity: O(1) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : 1. Reverse entired array 2.Reverse 0 to k elements and 3.Reverse k elements to n-1 .


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if nums is None or len(nums) == 0:
            return
        
        n = len(nums)
        if k > n:
            k = k % n
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
    
    def reverse(self, nums, l, r):
        while l < r:
            self.swap(nums, l, r)
            l += 1
            r -= 1
            
    def swap(self, nums, i, j):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp