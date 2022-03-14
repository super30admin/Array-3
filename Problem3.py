# // Time Complexity : O(n) where n is the length of the nums list.  
# // Space Complexity : O(1).
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        nums.reverse()
        n = len(nums)
        if n < 2:
            return
        k = k % n
        def reverse(nums,start,end):
            i = start
            j = end
            while(i<j):
                nums[i],nums[j] = nums[j],nums[i]
                i += 1
                j -= 1
        reverse(nums,0,k-1)
        reverse(nums,k,n-1)
