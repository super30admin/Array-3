'''
Time Complexity - O(n)
Space Complexity - O(1)

Works on Leetcode
'''
class Solution:
    def reverseArr(self, nums, start, end):
        #reverse the elements in a list
        l, r = start, end
        while l<r:
            nums[l],nums[r] = nums[r], nums[l]
            l+=1
            r-=1
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        k = k % len(nums) #if the k > length of the list
        #reverse the entire array
        self.reverseArr(nums, 0, len(nums)-1)
        #then reverse the elements from 0 to k-1 
        self.reverseArr(nums,0, k-1)
        #then reverse the remaining elements
        self.reverseArr(nums, k, len(nums)-1)
        