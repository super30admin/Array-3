#Time Complexity: O(N)
#Space Complexity: O(1)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def reverse(self, nums: list, start:int, end:int)->None:
        temp = 0
        while start < end:
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            
            start += 1
            end -= 1
        
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        
        if k > n:
            k = k%n
        
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
        
        
    
  