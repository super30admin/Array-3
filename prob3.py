# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# reverse the entire array, then reverse the first k elements, 
# then reverse the remaining n-k elements


class Solution:

    def rotate(self, nums, k):

        def swap(nums, i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

        def reverse(nums, start, end):

            while start < end:
                swap(nums, start, end)
                start += 1
                end -= 1
        
        if nums is None or len(nums) == 0:
            return
        n = len(nums)
        if k > n:
            k = k % n

        reverse(nums, 0, n-1)
        reverse(nums, 0, k-1)
        reverse(nums, k, n-1)