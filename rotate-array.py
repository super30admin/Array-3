# O(n) time, O(1) space
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # [1,2,3,4,5,6,7], k=3
        # index 5 -> 8 % 3 = 2-1
        # index 6 -> 9 % 3 = 0
        # index 5 -> 8 % 7 = 1
        # index 6 -> 9 % 7 = 2
        
        # [1,2,3,4,5,6,7]
        # [5,6,7,1,2,3,4]
        
        # [4,3,2,1,5,6,7]
        # [4,3,2,1,7,6,5]
        # [5,6,7,1,2,3,4]
        
        k=k%len(nums)
        
        # reverse up to first k elements
        l=0
        # get last index, then subtract k 
        r=len(nums)-1-k
        while l < r:
            nums[r],nums[l]=nums[l],nums[r]
            l+=1
            r-=1
        print(nums)
        # swap, so that first k elements are at the end
        l=0
        r=len(nums)-1
        while l < r:
            nums[r],nums[l]=nums[l],nums[r]
            l+=1
            r-=1
        print(nums)
        # reverse first k elements
        l=0
        r=k-1
        while l < r:
            nums[r],nums[l]=nums[l],nums[r]
            l+=1
            r-=1
        print(nums)
  
        # cleaner approach is to make the while loop a method, then:
        # you want to reverse the entire array first, then first half, then 2nd half 



class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #  l     r
        #. 0 1 2 3 4 5 6
        # [1,2,3,4,5,6,7] k=3
        # [4,3,2,1,5,6,7]
        # f someone asks you to rotate an array of size 7 by 10 times, rotating it 10 times is exactly the same # as rotating it 3 times (10 % 7 = 3).
        k=k%len(nums)
        l=0
        r=len(nums)-1-k
        # reverse all elements EXCEPT the last k elements
        self.helper(l,r,nums)
       # print(nums)
        # reverse entire array
        self.helper(0,len(nums)-1,nums)
       # print(nums)
        # reverse first k elements
        self.helper(0,k-1,nums)
       # print(nums)
    
    def helper(self,l,r,nums):
        while l < r:
            nums[l],nums[r]=nums[r],nums[l]
            l+=1
            r-=1
