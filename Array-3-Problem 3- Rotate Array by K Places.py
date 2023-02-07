"""
FAANMG Problem #120 {Easy} 

189. Rotate Array

# Time complexity : O(n)
# Space complexity : O(1)

Did this code successfully run on Leetcode : Yes



@name: Rahul Govindkumar
"""

class Solution:
    
    def reverse(self,nums,start, end):
        # reverse the elements in the sub-array defined by start and end
        while start < end:
            
            nums[start], nums[end] = nums[end], nums[start]
            
            start +=1
            end -=1
        
        
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        
        # reduce k to a value in the range [0, n - 1]
        k = k % n
        
        # reverse the entire list
        self.reverse(nums, 0 , n-1)
        
        # reverse the first k elements
        self.reverse(nums, 0 , k-1)
        
        # reverse the remaining n - k elements
        self.reverse(nums, k , n -1)
        
        return nums
        