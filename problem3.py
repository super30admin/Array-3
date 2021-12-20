#Time O(n), space O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
 #Reverse all the items, then k items and then from k to n items       
        n=len(nums)
        k=k%n
        self.reverse(nums,0,n-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,n-1)

#Reverse 
    def reverse(self,nums,i,j):
      
        while i<j:
            nums[i],nums[j]=nums[j],nums[i]
            i+=1
            j-=1
