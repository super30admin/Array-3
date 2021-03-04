#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if(nums==None or len(nums)==0):
            return []
        n=len(nums)
        self.reverse(nums,0,n-1)
       
        k=k%n
        
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,n-1)
        return nums
    
    def reverse(self,nums,l,r):
        while(l<r):
            self.swap(nums,l,r)
            l+=1
            r-=1
    
    def swap(self,nums,i,j):
        temp=nums[i]
        nums[i]=nums[j]
        nums[j]=temp