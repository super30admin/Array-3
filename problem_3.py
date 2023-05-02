# Time Complexity - O(n)
# Space Complexity - O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if k > n :
            k = k % n 
        self.reverse(nums,0,n-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,n-1)

    def reverse(self,nums,left,right):
        while left < right:
            nums[left],nums[right]= nums[right],nums[left]
            left += 1
            right -= 1
       

