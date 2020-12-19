"""
Time complexity O(N)
Space complexity O(1)

1. Reverse all element 
2. Reverse n element 
3. Reverse n-k element

"""

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return 0
        n=len(nums)
        if(k>=n):
            k=k%n
        
        self.reverse(nums,0,n-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,n-1)
    
    def reverse(self,nums,l,r):
        while(l<r):
            self.swap(nums,l,r)
            l+=1
            r-=1
    
    def swap(self,nums,i,j):
        temp=nums[i]
        nums[i]=nums[j]
        nums[j]=temp
        
        
        