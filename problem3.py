#time complexity :O(n)
#space complexity:O(1)
#ran on leetcode: Yes
#find out the index from the original array which would be in position 0 is rotated array . reverse the array from 0 to pos and pos+1 to end. reverse the entire array
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        pos=0
        c=k
        #find out the index from the original array which would be in position 0 is rotated array 
        pos=0
        k=k%len(nums)
        pos=(len(nums)-k)
        #reverse the list from 0 to pos and pos+1 to end
        i=0
        j=pos-1
        while(i<j):
            temp=nums[i]
            nums[i]=nums[j]
            nums[j]=temp
            i=i+1
            j=j-1
        i=pos
        j=len(nums)-1
        while(i<j):
            temp=nums[i]
            nums[i]=nums[j]
            nums[j]=temp
            i=i+1
            j=j-1
        #reverse the entire arrasy
        i=0
        j=len(nums)-1
        while(i<j):
            temp=nums[i]
            nums[i]=nums[j]
            nums[j]=temp
            i=i+1
            j=j-1
