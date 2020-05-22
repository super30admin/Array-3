"""
// Time Complexity : O(n) n is length of shorter array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
Reverse the array
Swap the elements from 0 to k-1
Swap the elements from k to end
"""

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        def swap(i,j):
            while i < j:
                nums[i],nums[j] = nums[j],nums[i]
                i+=1
                j-=1
        
        """
        Do not return anything, modify nums in-place instead.
        """
        nums.reverse()
        #swap elements from 0 to k-1
        swap(0,k-1)
        
        #swap the elements from k to end
        swap(k,len(nums)-1)