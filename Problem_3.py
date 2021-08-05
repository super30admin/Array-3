from typing import List
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if nums == None or len(nums) == 0:
            return
        n = len(nums)
        if k >= n:
            k = k % n
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
    
    def reverse(self, nums: List[int], l: int, r: int) -> None:
        while l <= r:
            self.swap(nums, l, r)
            l += 1
            r -= 1
            
    def swap(self, nums: List[int], l: int, r: int) -> None:
        temp = nums[l]
        nums[l] = nums[r]
        nums[r] = temp
        
# Time Complexity: O(n)
# Space Complexity: O(1)