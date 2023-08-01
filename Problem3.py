#Time complexity is: O(n)
#Space complexity is: O(1)
#No issues faced while coding
#Code ran successfully on leetcode

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        #Base case
        if(nums==None or len(nums)==0):
            return nums
        n=len(nums)
        #Handling case where k>n
        if(k>n):
            k=k%n
        #Reversing entire array
        self.reverse(nums,0,n-1)
        #Reversing k values in the array
        self.reverse(nums,0,k-1)
        #Reveresing the remaining n-k values
        self.reverse(nums,k,n-1)

    def reverse(self, nums, left, right):
        #We will take two pointers left and right 
        #We will be swapping values until left and right crosses each other
        while(left<=right):
            self.swap(nums,left,right)
            left+=1
            right-=1
    #Function to swap values at two different indexes
    def swap(self,nums,left,right):
        temp=nums[left]
        nums[left]=nums[right]
        nums[right]=temp