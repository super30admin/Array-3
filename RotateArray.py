'''
Solution:
1.  The idea is to perform reverse operation 3 times on 3 different chunks as below -
            [1 2 3 4 5 6 7 8] - k = 3
    (i)     [8 7 6 5 4 3 2 1]   - reversed entire array
    (ii)    [6 7 8 5 4 3 2 1]   - reversed first k chunk
    (iii)   [6 7 8 1 2 3 4 5]   - reversed remaining n-k chunk

Time Complexity:    O(n)    |   Space Complexity:   O(1)
--- Passed all testcases on Leetcode successfully
'''

class RotateArray:

    def __swap(self, nums, left, right):

        #   function to swap elements at two indices
        temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp

    def __reverse(self, nums, start, end):

        #   function to reverse a chunk of an array
        while (start < end):
            self.__swap(nums, start, end)
            start += 1
            end -= 1

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #   edge case check
        if (nums == None or len(nums) == 0):
            return

        #   initializations
        n = len(nums)
        k = k % n

        #   reverse the array 3 times on 3 different chunks
        self.__reverse(nums, 0, n - 1)
        self.__reverse(nums, 0, k - 1)
        self.__reverse(nums, k, n - 1)