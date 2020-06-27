#Time complexity:O(n)
#SC:O(1)
#Ran successfully on Leetcode:yes
#Approach- First step is to reverse the entire array. 
# Then the part before the kth element in the array is reversed and 
# then the part after that is also reversed. 

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k%=len(nums)
        self.reverse(nums,0,len(nums)-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,len(nums)-1)
    def swap(self,nums,i,j):
            temp=nums[i]
            nums[i]=nums[j]
            nums[j]=temp
    def reverse(self,nums,l,r):
            while l<=r:
                self.swap(nums,l,r)
                l+=1
                r-=1
        
