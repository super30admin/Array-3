#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if k>n:
            k = k%n
        
        nums.reverse()
       
        self.reverseNums(0,k-1,nums)
        self.reverseNums(k,n-1,nums)
              
        
    def reverseNums(self,low,high,nums):
        while low<high:
            nums[low],nums[high] = nums[high],nums[low]
            low += 1
            high -= 1
            
            