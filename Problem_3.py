# Rotate Array 

# Time Complexity : O(N)
# Space Complexity : O(1) as no extra space is required
# Did this code successfully run on Leetcode : Yes, with Runtime: 60 ms and Memory Usage: 15.6 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Approach
"""
We do n-k such that we rotate the array k times, k elements from back come to front 
and front shifts backwards. We reverse all the elements of the array.

"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        
        """
        if(nums==None or len(nums)==0): # Base Case
            return
        n=len(nums)
        if(k>n):
            k=k%n
        def swap(nums,i,j):
            temp=nums[i]
            nums[i]=nums[j]
            nums[j]=temp
        
        def reverse(nums,l,r):
            while(l<r):
                swap(nums,l,r)
                l=l+1
                r=r-1
        
        reverse(nums,0,n-1)
        reverse(nums,0,k-1)
        reverse(nums,k,n-1)