------------------------Rotate Array--------------------------------------------

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we will just reverse the first k elements with last k elements and last n-k elements with first n-k elements

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if not nums or k == 0 or k == len(nums) or len(nums) == 1:
            return nums
        
        k = k%len(nums)
        nums[:k] , nums[k:] = nums[-k:], nums[:-k]
        
        
------------------------Rotate Array --------------------------------------------

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# as the same approach, I just reverse the first and last elements and then just reverse the first k elements.
and last n-k elements.
       
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if not nums:
            return []
        
        i = 0
        j = len(nums)-1
        k = k%len(nums)
        while i<=j:
            nums[i], nums[j] = nums[j], nums[i]
            i +=1
            j -=1
            
        
        nums[:k], nums[k:] = nums[:k][::-1], nums[k:][::-1]