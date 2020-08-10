class Solution:
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : O(N)
        Space : O(1)

        Paseed Test Cases : Yes
        
    """
    
    # Given the index this method swaps the numbers in an array
    def swap(self, pos1, pos2, nums):
        temp = nums[pos1]
        nums[pos1] = nums[pos2]
        nums[pos2] = temp
    
    # This method rotates the array to right by 1 spacee
    def rotateOneSpace(self, nums):
        for i in range(len(nums)-1):
            if i - 1 == -1: # for left rotation it should be i + 1 and have to check with len(nums)-1
                index = len(nums)-1
            else:
                index = i - 1
            self.swap(i, index, nums)
    
    # This method reverses from starting and ending index
    def reverse(self, nums, start, end):
        while start < end:
            self.swap(start, end, nums)
            start += 1
            end -= 1
    
    # This method shifts the array by k times using the reversing logic
    def rotateByReverse(self, nums, k):
        self.reverse(nums, 0, len(nums)-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, len(nums)-1)
        
    
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if not nums:
            return
        k = k%len(nums)
        # for i in range(len(nums)- k):
        #     self.rotateOneSpace(nums)
        self.rotateByReverse(nums, k)
        
