# Time Complexity : O(n)[n = length of nums list]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:        
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if not nums or len(nums) == 1 or k % n == 0:return
        k = k % n
        
        def reverse(start, end):
            while start<end:
                nums[start], nums[end] = nums[end], nums[start]
                start+=1
                end-=1
        
        # reverse the entire list
        # [1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
        reverse(0, n-1)
        
        # reverse the first k elemenst
        # [7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]
        reverse(0, k-1)
        
        # reverse the last n-k elements
        # [5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
        reverse(k, n-1)