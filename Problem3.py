## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums == None or len(nums)==0:
            return 
        n = len(nums)
        k = k % n
        self.reverse(nums,0,n-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,n-1)
    def reverse(self, nums, l,r):
        while l<=r:
            self.swap(nums,l,r)
            l = l+1
            r = r-1
    def swap(self,nums,l,r):
        temp = nums[l]
        nums[l] = nums[r]
        nums[r]=temp 
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #Approach: reverse the entire array and then reverse it untill the k-1 index and then reverse the other array (k,n). Reverse is done by swapping. 