# Time Complexity : O(n) where n is length of list
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """

        # while k>0:
        #     nums.insert(0,nums.pop())
        #     k-=1

        # method to reverse a part of list from start to end index
        def reverse(start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1

        l = len(nums)
        # if k >l then k will be equal to k % l
        k = k % l
        # Reveresed entire array
        reverse(0, l - 1)
        # Reversed first k elements
        reverse(0, k - 1)
        # Reversed remaining elements
        reverse(k, l - 1)