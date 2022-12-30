# Time Complexity : O(n), Where n is number of elements in nums list 
# Space Complexity : O(1), 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
class Solution:
    def reverse(self, array, l, r)->None:
        while(l<=r):
            array[l],array[r]=array[r],array[l]#Swapping the elements at l and r respectively
            l+=1
            r-=1
            
            
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        k=k%n
        self.reverse(nums,n-k,n-1)
        self.reverse(nums,0,n-k-1)
        self.reverse(nums,0,n-1)