"""
Problem : 3

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


First rotating the entire array to get last k number at the start of the array
reversing that part of the array to arrange them in their original order
and also reversing the remaining part to rearrange them to their original order

"""

# Rotate Array by K Places

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        def swap(i,j):
            temp=nums[i]
            nums[i]=nums[j]
            nums[j]=temp

        def reverse(left,right):
            while left<=right:
                swap(left,right)
                left+=1
                right-=1
        
        if not nums:
            return nums
        n=len(nums)

        if k>n:
            k=k%n
        
        reverse(0,n-1)
        reverse(0,k-1)
        reverse(k,n-1)
        return nums