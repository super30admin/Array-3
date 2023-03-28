#All TC on leetcode passed

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

         #Here we reverse all elements, then 1st k elements and finally last (n-k) elements to get the rotated array
        #Time complexity - O(n)
        #Space complexity - O(1)
        n = len(nums)
        k = k%n
        self.reverseNums(nums, 0, n-1)
        self.reverseNums(nums, 0, k-1)
        self.reverseNums(nums, k, n-1)

        return nums
    
    def reverseNums(self, nums, l, r):
        while l<=r:
            nums[l], nums[r] = nums[r], nums[l]
            l+=1
            r-=1

        
        
#--------------------------------------------OR-------------------------------------------

        #Here we pop last element and insert it at 1st position of the array, this is done k times
        #Time complexity - O(n.k)
        #Space complexity - O(1)
    def rotate(self, nums: List[int], k: int) -> None:
        for i in range(k):
            nums.insert(0, nums.pop())
        return nums
        