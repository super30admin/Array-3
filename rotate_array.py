# Time Complexity :
# O(N)  - Size of the List

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We reverse the array from position 0 to n-k, then form n-k to end. Then reverse the entire array - this will ensure the original array has rotated by k steps

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k == 0 :
            return
        num_switches = 0
        n = len(nums)

        if k > n :
            k = k % n
        low = 0
        high = n-k-1
        self.reverse(nums,low,high)
        low = n-k
        high = n-1
        self.reverse(nums,low,high)
        low = 0
        high = n-1
        self.reverse(nums,low,high)
        
    def reverse(self,array,low,high):
        while low <= high :
            self.swap(array,low,high)
            low += 1
            high -= 1

    def swap(self,array,i,j):
        temp = array[i]
        array[i] = array[j]
        array[j] = temp
