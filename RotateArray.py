'''
TC: O(n) - reversing in place and then reversing k elements and n-k elements next 
            leading to a total of n complexity
SC: O(1) - Computing in-place
'''
from typing import List

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) < k:
            k = k%len(nums)
            
        def reverse(l,r):
            while l<r:
                nums[l],nums[r] = nums[r],nums[l]
                l+=1
                r-=1
        
        #Reverse the list
        reverse(0,len(nums)-1)
        #Reverse first k
        reverse(0,k-1)
        #Reverse the last - n-k
        reverse(k,len(nums)-1)
        print(nums)
s = Solution()
s.rotate([1,2,3,4,5,6,7],3)
s.rotate([-1,-100,3,99],2)