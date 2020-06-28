#Time Complexity: O(N)
#Space Complexity : O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if (len(nums) ==0) or (len(nums) < 2):
            return nums
        if k > len(nums):
            k = k% len(nums)
        
        def swap(nums,i,j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        def reverse(nums,l,r):
            while(l<r):
                swap(nums,l,r)
                l+=1
                r-=1
        
       
        n = len(nums) -1
        reverse(nums,0,n)
        reverse(nums,0,k-1)
        reverse(nums,k,n)
        