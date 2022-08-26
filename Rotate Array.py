# Time complexity: O(n)
# Space complexity: O(1)
# Approach: reverse elements from 0 to n-k-1
# reverse elements from n-k to n
# reverse all the elements now from 0 to n-1.


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        self.reverse(nums, 0, n-k-1)
        self.reverse(nums, n-k, n-1)
        self.reverse(nums, 0, n-1)
        
    def reverse(self, nums, l, r):
        while(l <= r):
            self.swap(nums,l,r)
            l += 1
            r -= 1
    def swap(self,nums,l,r):
        temp = nums[l]
        nums[l] = nums[r]
        nums[r] = temp
        
        
        