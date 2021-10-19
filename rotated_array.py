# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        
        """
        if k>len(nums):
            k=k%len(nums)
            
        nums.reverse()

        for i in range(k//2):
            nums[i],nums[k-1-i]=nums[k-1-i],nums[i]
        n=len(nums)
        for i in range((n-k)//2):
            print(k+i,n-i)
            nums[k+i],nums[n-1-i]=nums[n-1-i],nums[k+i]
            
        
        
        
#     def reverse(self,nums):
#         nums=nums[::-1]
#         print(nums)
#         return nums
    